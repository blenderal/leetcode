package unionfind;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * 947. 移除最多的同行或同列石头
 * n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
 *
 * 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
 *
 * 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * 输出：5
 * 解释：一种移除 5 块石头的方法如下所示：
 * 1. 移除石头 [2,2] ，因为它和 [2,1] 同行。
 * 2. 移除石头 [2,1] ，因为它和 [0,1] 同列。
 * 3. 移除石头 [1,2] ，因为它和 [1,0] 同行。
 * 4. 移除石头 [1,0] ，因为它和 [0,0] 同列。
 * 5. 移除石头 [0,1] ，因为它和 [0,0] 同行。
 * 石头 [0,0] 不能移除，因为它没有与另一块石头同行/列。
 * 示例 2：
 *
 * 输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * 输出：3
 * 解释：一种移除 3 块石头的方法如下所示：
 * 1. 移除石头 [2,2] ，因为它和 [2,0] 同行。
 * 2. 移除石头 [2,0] ，因为它和 [0,0] 同列。
 * 3. 移除石头 [0,2] ，因为它和 [0,0] 同行。
 * 石头 [0,0] 和 [1,1] 不能移除，因为它们没有与另一块石头同行/列。
 * 示例 3：
 *
 * 输入：stones = [[0,0]]
 * 输出：0
 * 解释：[0,0] 是平面上唯一一块石头，所以不可以移除它。
 *
 *
 * 提示：
 *
 * 1 <= stones.length <= 1000
 * 0 <= xi, yi <= 104
 * 不会有两块石头放在同一个坐标点上
 * @author: zww
 * @date: 2021/1/15
 * @version: V1.0
 */
public class RemoveStones {
    public static void main(String[] args) {
        System.out.println(removeStones(new int[][]{
                {0,0},
                {0,1},
                {1,0},
                {1,2},
                {2,1},
                {2,2}
        }));
    }
    public static int removeStones(int[][] stones) {
        Map<Integer,Integer> hmap  = new HashMap<>();
        Map<Integer, Integer> wmap = new HashMap<>();
        int l = stones.length;
        int[] parent = new int[l];
        for (int i = 0; i < l; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < l; i++) {
            Integer h = hmap.get(stones[i][0]);
            Integer w = wmap.get(stones[i][1]);
            if (h != null) {
                union(i, h, parent);
            }
            if (w != null) {
                union(i, w, parent);
            }
            if (!hmap.containsKey(stones[i][0])) {
                hmap.put(stones[i][0], i);
            }
            if (!wmap.containsKey(stones[i][1])) {
                wmap.put(stones[i][1], i);
            }
        }
        int ret = 0;
        for (int i = 0; i < l; i++) {
            if (parent[i] == i) {
                ret++;
            }
        }
        return l-ret;
    }
    public static int find(int x,int[] parent){
        if(parent[x] !=x){
            parent[x] = find(parent[x],parent);
        }
        return parent[x];
    }
    public static void union(int x,int y,int[] parent){
        int rootX = find(x, parent);
        int rootY = find(y, parent);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }

}
