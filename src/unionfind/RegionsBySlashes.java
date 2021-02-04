package unionfind;

/**
 * @description:
 * 959. 由斜杠划分区域
 * 在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。
 *
 * （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。
 *
 * 返回区域的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   " /",
 *   "/ "
 * ]
 * 输出：2
 * 解释：2x2 网格如下：
 *
 * 示例 2：
 *
 * 输入：
 * [
 *   " /",
 *   "  "
 * ]
 * 输出：1
 * 解释：2x2 网格如下：
 *
 * 示例 3：
 *
 * 输入：
 * [
 *   "\\/",
 *   "/\\"
 * ]
 * 输出：4
 * 解释：（回想一下，因为 \ 字符是转义的，所以 "\\/" 表示 \/，而 "/\\" 表示 /\。）
 * 2x2 网格如下：
 *
 * 示例 4：
 *
 * 输入：
 * [
 *   "/\\",
 *   "\\/"
 * ]
 * 输出：5
 * 解释：（回想一下，因为 \ 字符是转义的，所以 "/\\" 表示 /\，而 "\\/" 表示 \/。）
 * 2x2 网格如下：
 *
 * 示例 5：
 *
 * 输入：
 * [
 *   "//",
 *   "/ "
 * ]
 * 输出：3
 * 解释：2x2 网格如下：
 *
 *
 *
 * 提示：
 *
 * 1 <= grid.length == grid[0].length <= 30
 * grid[i][j] 是 '/'、'\'、或 ' '。
 * @author: zww
 * @date: 2021/1/25
 * @version: V1.0
 */
public class RegionsBySlashes {
    public static void main(String[] args) {
        System.out.println(regionsBySlashes(new String[]{
                "//",
                "/ "
        }));
    }
    public static int regionsBySlashes(String[] grid) {
        int l = grid.length;
        DisjointUnionSet disjointUnionSet = new DisjointUnionSet(4*l*l);
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                int index = i*l+j;
                if(i<l-1){
                    disjointUnionSet.union(4*index+2,4*(index + l));
                }
                if(j<l-1){
                    disjointUnionSet.union(4*index+1,4*(index + 1)+3);
                }
                if (grid[i].charAt(j) == '/'){
                    disjointUnionSet.union(4*index,4*index+3);
                    disjointUnionSet.union(4*index+1,4*index+2);
                }else if(grid[i].charAt(j) == '\\'){
                    disjointUnionSet.union(4*index,4*index+1);
                    disjointUnionSet.union(4*index+2,4*index+3);
                }else {
                    disjointUnionSet.union(4*index,4*index+1);
                    disjointUnionSet.union(4*index+1,4*index+2);
                    disjointUnionSet.union(4*index+2,4*index+3);
                }
            }
        }
        return disjointUnionSet.setCount;
    }
    static class DisjointUnionSet{
        int[] rank;
        int[] f;
        int n;
        int setCount;

        public DisjointUnionSet(int n) {
            this.n = n;
            this.setCount = n;
            rank = new int[n];
            f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = i;
                rank[i] = 1;
            }
        }

        private void union(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return;
            }
            if(rank[rootX]<rank[rootY]){
                int temp = rootX;
                rootX = rootY;
                rootY = temp;
            }
            rank[x]+=rank[rootY];
            f[rootY] = rootX;
            setCount--;
        }
        private int find(int x){
            if(f[x]!=x){
                f[x] = find(f[x]);
            }
            return f[x];
        }
    }
}
