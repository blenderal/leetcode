package unionfind;

/**
 * @description: 1319. 连通网络的操作次数
 * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 * <p>
 * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 * <p>
 * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, connections = [[0,1],[0,2],[1,2]]
 * 输出：1
 * 解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
 * 输出：-1
 * 解释：线缆数量不足。
 * 示例 4：
 * <p>
 * 输入：n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^5
 * 1 <= connections.length <= min(n*(n-1)/2, 10^5)
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] < n
 * connections[i][0] != connections[i][1]
 * 没有重复的连接。
 * 两台计算机不会通过多条线缆连接。
 * @author: zww
 * @date: 2021/1/23
 * @version: V1.0
 */
public class MakeConnected {
    public static void main(String[] args) {
        System.out.println(makeConnected(5, new int[][]{
                {0, 1},
                {0, 2},
                {3, 4},
                {2, 3},
//                {1,3}
        }));
    }

    public static int makeConnected(int n, int[][] connections) {
        int l = connections.length;
        if (l < n - 1) {
            return -1;
        }
        DisjointSetUnion disjointSetUnion = new DisjointSetUnion(n);
        for (int i = 0; i < l; i++) {
            disjointSetUnion.union(connections[i][0], connections[i][1]);
        }
        return disjointSetUnion.setCount - 1;
    }

    static class DisjointSetUnion {
        int[] rank;
        int[] f;
        int n;
        int setCount;

        public DisjointSetUnion(int n) {
            this.n = n;
            this.setCount = n;
            rank = new int[n];
            f = new int[n];
            for (int i = 0; i < n; i++) {
                rank[i] = 1;
                f[i] = i;
            }
        }

        public int find(int x) {
            if (f[x] != x) {
                f[x] = find(f[x]);
            }
            return f[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (rank[rootX] < rank[rootY]) {
                int temp = rootX;
                rootX = rootY;
                rootY = temp;
            }
            rank[rootX] += rank[rootY];
            f[rootY] = rootX;
            setCount--;
        }
    }
}
