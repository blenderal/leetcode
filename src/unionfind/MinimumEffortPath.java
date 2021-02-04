package unionfind;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @description:
 * 1631. 最小体力消耗路径
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 *
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 *
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
 * 示例 2：
 *
 *
 *
 * 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
 * 输出：1
 * 解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
 * 示例 3：
 *
 *
 * 输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * 输出：0
 * 解释：上图所示路径不需要消耗任何体力。
 *
 *
 * 提示：
 *
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 * @author: zww
 * @date: 2021/1/29
 * @version: V1.0
 */
public class MinimumEffortPath {
    public static void main(String[] args) {
        System.out.println(minimumEffortPath(new int[][]{
                {4,3,4,10,5,5,9,2},
                {10,8,2,10,9,7,5,6},
                {5,8,10,10,10,7,4,2},
                {5,1,3,1,1,3,1,9},
                {6,4,10,6,10,9,4,6}
        }));
    }
    public static int minimumEffortPath(int[][] heights) {
        int h = heights.length;
        int w = heights[0].length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int cur = heights[i][j];
                if(i > 0){
                    edges.add(new int[]{i * w + j, (i-1) * w + j, Math.abs(cur - heights[i - 1][j])});
                }
                if(j>0){
                    edges.add(new int[]{i * w + j, i * w + j - 1, Math.abs(cur - heights[i][j - 1])});
                }
            }
        }
        UnionFind unionFind = new UnionFind(h * w);
        edges.sort(Comparator.comparingInt(o -> o[2]));
        for (int[] edge : edges) {
            if (unionFind.union(edge[0], edge[1])) {
                return edge[2];
            }

        }
        return 0;
    }

    static class UnionFind{
        int n;
        int[] f;
        int[] rank;
        int setCount;

        public UnionFind(int n) {
            this.n = n;
            this.setCount = n;
            f = new int[n];
            rank = new int[n];
            for (int i = 0; i <n ; i++) {
                rank[i] = 1;
                f[i] = i;
            }
        }
        public int find(int x){
            if(f[x]!=x){
                f[x] = find(f[x]);
            }
            return f[x];
        }
        public boolean union(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return false;
            }
            if(rank[rootX]<rank[rootY]){
                int temp = rootX;
                rootX = rootY;
                rootY = temp;
            }
            rank[rootX]+=rank[rootY];
            setCount--;
            f[rootY] = rootX;
            return find(0) == find(n-1);
        }
    }
}
