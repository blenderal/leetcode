package unionfind;

import com.sun.javafx.geom.Edge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @description:
 * 1584. 连接所有点的最小费用
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 *
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 *
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 * 解释：
 *
 * 我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
 * 注意到任意两个点之间只有唯一一条路径互相到达。
 * 示例 2：
 *
 * 输入：points = [[3,12],[-2,5],[-4,1]]
 * 输出：18
 * 示例 3：
 *
 * 输入：points = [[0,0],[1,1],[1,0],[-1,1]]
 * 输出：4
 * 示例 4：
 *
 * 输入：points = [[-1000000,-1000000],[1000000,1000000]]
 * 输出：4000000
 * 示例 5：
 *
 * 输入：points = [[0,0]]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= points.length <= 1000
 * -106 <= xi, yi <= 106
 * 所有点 (xi, yi) 两两不同。
 * @author: zww
 * @date: 2021/1/19
 * @version: V1.0
 */
public class MinCostConnectPoints {
    public static void main(String[] args) {
        System.out.println(minCostConnectPoints(new int[][]{
//                {3,12},
//                {-2,5},
//                {-4,1}
//                {0,0},
//                {2,2},
//                {3,10},
//                {5,2},
//                {7,0}
                {0,0},
                {1,1},
                {1,0},
                {-1,1}

        }));
    }
    public static int minCostConnectPoints(int[][] points) {
        List<Edge> edgeList = new ArrayList<>();
        int l = points.length;
        DisjointSetUnion union = new DisjointSetUnion(l);
        for (int i = 0; i < l; i++) {
            for (int j = i+1; j < l; j++) {
                edgeList.add(new Edge(i,j,dist(points,i,j)));
            }
        }
        int edgeNum = 1;
        int minCost = 0;
        edgeList.sort(Comparator.comparingInt(o -> o.distance));
        int size = edgeList.size();
        for (int i = 0; i < size; i++) {
            if(union.union(edgeList.get(i).x,edgeList.get(i).y)){
                minCost += edgeList.get(i).distance;
                if(++edgeNum == l){
                    break;
                }
            }
        }
        return minCost;
    }

    public static int dist(int[][] points,int x,int y){
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }
    static class Edge{
        public int x;
        public int y;
        public int distance;

        public Edge(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    static class DisjointSetUnion{
        int[] f;
        int[] rank;
        int n;

        public DisjointSetUnion(int n) {
            this.n = n;
            this.f = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = i;
                rank[i] = 1;
            }
        }

        public boolean union(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX ==rootY){
                return false;
            }
            if(rootX < rootY){
                int temp = rootX;
                rootX = rootY;
                rootY = temp;
            }
            rank[rootX]+=rank[rootY];
            f[rootY] = rootX;
            return true;
        }
        public int find(int x){
            if(f[x]!=x){
                f[x] = find(f[x]);
            }
            return f[x];
        }
    }
}

