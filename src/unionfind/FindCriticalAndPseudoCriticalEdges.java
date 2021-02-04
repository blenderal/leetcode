package unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description:
 * 1489. 找到最小生成树里的关键边和伪关键边
 * 给你一个 n 个点的带权无向连通图，节点编号为 0 到 n-1 ，同时还有一个数组 edges ，其中 edges[i] = [fromi, toi, weighti] 表示在 fromi 和 toi 节点之间有一条带权无向边。最小生成树 (MST) 是给定图中边的一个子集，它连接了所有节点且没有环，而且这些边的权值和最小。
 *
 * 请你找到给定图中最小生成树的所有关键边和伪关键边。如果从图中删去某条边，会导致最小生成树的权值和增加，那么我们就说它是一条关键边。伪关键边则是可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边。
 *
 * 请注意，你可以分别以任意顺序返回关键边的下标和伪关键边的下标。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 5, edges = [[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]
 * 输出：[[0,1],[2,3,4,5]]
 * 解释：上图描述了给定图。
 * 下图是所有的最小生成树。
 *
 * 注意到第 0 条边和第 1 条边出现在了所有最小生成树中，所以它们是关键边，我们将这两个下标作为输出的第一个列表。
 * 边 2，3，4 和 5 是所有 MST 的剩余边，所以它们是伪关键边。我们将它们作为输出的第二个列表。
 * 示例 2 ：
 *
 *
 *
 * 输入：n = 4, edges = [[0,1,1],[1,2,1],[2,3,1],[0,3,1]]
 * 输出：[[],[0,1,2,3]]
 * 解释：可以观察到 4 条边都有相同的权值，任选它们中的 3 条可以形成一棵 MST 。所以 4 条边都是伪关键边。
 *
 *
 * 提示：
 *
 * 2 <= n <= 100
 * 1 <= edges.length <= min(200, n * (n - 1) / 2)
 * edges[i].length == 3
 * 0 <= fromi < toi < n
 * 1 <= weighti <= 1000
 * 所有 (fromi, toi) 数对都是互不相同的。
 * @author: zww
 * @date: 2021/1/21
 * @version: V1.0
 */
public class FindCriticalAndPseudoCriticalEdges {
    public static void main(String[] args) {
        System.out.println(findCriticalAndPseudoCriticalEdges(5,new int[][]{
                {0,1,1},
                {1,2,1},
                {2,3,2},
                {0,3,2},
                {0,4,3},
                {3,4,3},
                {1,4,6}
        }));
    }
    public static List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int l = edges.length;
        int[][] copy = new int[l][4];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < 3; j++) {
                copy[i][j] = edges[i][j];
            }
            copy[i][3] = i;
        }
        Arrays.sort(copy, Comparator.comparingInt(o -> o[2]));
        int minWeight = 0;
        DisjointSetUnion disjointSetUnion = new DisjointSetUnion(n);
        for (int i = 0; i < l; i++) {
            if(disjointSetUnion.union(copy[i][0],copy[i][1])){
                minWeight += copy[i][2];
            }
        }
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());
        ret.add(new ArrayList<>());
        for (int i = 0; i < l; i++) {
            disjointSetUnion = new DisjointSetUnion(n);
            int w = 0;
            for (int j = 0; j < l; j++) {
                if(j !=i && disjointSetUnion.union(copy[j][0],copy[j][1])){
                    w += copy[j][2];
                }
            }
            if(disjointSetUnion.setCount != 1 || w > minWeight){
                ret.get(0).add(copy[i][3]);
                continue;
            }
            disjointSetUnion =  new DisjointSetUnion(n);
            disjointSetUnion.union(copy[i][0],copy[i][1]);
            w = copy[i][2];
            for (int j = 0; j < l; j++) {
                if(j !=i && disjointSetUnion.union(copy[j][0],copy[j][1])){
                    w += copy[j][2];
                }
            }
            if(w == minWeight){
                ret.get(1).add(copy[i][3]);
            }
        }
        return ret;
    }


    static class DisjointSetUnion{
        int[] rank;
        int[] f;
        int n;
        int setCount;

        public DisjointSetUnion(int n) {
            this.n = n;
            f = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                rank[i] = 1;
                f[i] = i;
            }
            this.setCount = n;
        }

        public boolean union(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return false;
            }
            if(rank[rootX] < rank[rootY]){
                int temp = rootY;
                rootY = rootX;
                rootX = temp;
            }
            rank[rootX]+=rank[rootY];
            f[rootY] = rootX;
            setCount --;
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
