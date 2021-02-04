package unionfind;

/**
 * @description:
 * 839. 相似字符串组
 * 如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。
 *
 * 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。
 *
 * 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
 *
 * 给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["tars","rats","arts","star"]
 * 输出：2
 * 示例 2：
 *
 * 输入：strs = ["omv","ovm"]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 100
 * 1 <= strs[i].length <= 1000
 * sum(strs[i].length) <= 2 * 104
 * strs[i] 只包含小写字母。
 * strs 中的所有单词都具有相同的长度，且是彼此的字母异位词。
 * @author: zww
 * @date: 2021/1/31
 * @version: V1.0
 */
public class NumSimilarGroups {
    public static void main(String[] args) {
        System.out.println(numSimilarGroups(new String[]{
                "nmiwx","mniwx","wminx","mnixw","xnmwi"
        }));
    }
    public static int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int l = strs[0].length();
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (unionFind.find(i) == unionFind.find(j)) {
                    continue;
                }
                int count = 0;
                for (int k = 0; k < l; k++) {
                    if(strs[i].charAt(k) != strs[j].charAt(k)){
                        count++;
                    }
                    if(count > 2){
                        break;
                    }
                }
                if(count <= 2){
                    unionFind.union(i,j);
                }
            }
        }
        return unionFind.setCount;
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
