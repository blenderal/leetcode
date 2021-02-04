package unionfind;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 并查集
 * 547. 省份数量
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * 示例 2：
 *
 *
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 * @author: zww
 * @date: 2021/1/7
 * @version: V1.0
 */
public class FindCircleNum {
    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{
                {1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}
//                {1,1,0},
//                {0,1,0},
//                {0,0,1}
        }));
    }
    public static int findCircleNum(int[][] M) {
        int h = M.length;
        int[] parent = new int[h];
        int result = h;
        for (int i = 0; i < h; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < h; i++) {
            for (int j = i+1; j < h; j++) {
                if(M[i][j] == 1){
                    if(union(parent,i,j)){
                        result--;
                    }
                }
            }
        }
        return result;
    }

    private static boolean union(int[] parent, int x, int y) {
        int rootX = find(parent,x);
        int rootY = find(parent,y);
        if(rootX!=rootY){
            parent[rootX] = rootY;
            return true;
        }
        return false;
    }

    private static int find(int[] parent, int y) {
        if(parent[y]!=y){
            parent[y] = find(parent,parent[y]);
        }
        return parent[y];
    }

//    public static int findCircleNum(int[][] M) {
//        Map<Integer, Integer> fatherMap = new HashMap<>();
//        int h = M.length;
//        int result = h;
//        for (int i = 0; i < h; i++) {
//            fatherMap.put(i, i);
//        }
//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < h; j++) {
//                if (M[i][j] == 1) {
//                    result -= merge(fatherMap, i, j);
//                }
//            }
//        }
//        return result;
//    }
//
//    public static int merge(Map<Integer, Integer> fatherMap, int x, int y) {
//        int rootX = find(fatherMap, x);
//        int rootY = find(fatherMap, y);
//        int result = 0;
//        if (rootX != rootY) {
//            fatherMap.put(rootX, rootY);
//            result = 1;
//        }
//        return result;
//    }
//
//    public static int find(Map<Integer, Integer> fatherMap, int x) {
//        if (fatherMap.get(x) != x) {
//            fatherMap.put(x, find(fatherMap, fatherMap.get(x)));
//        }
//        return fatherMap.get(x);
//    }

}
