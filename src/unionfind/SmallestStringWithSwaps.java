package unionfind;

import java.util.*;

/**
 * @description:
 * 1202. 交换字符串中的元素
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 *
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 *
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 * 示例 2：
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * 输出："abcd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[0] 和 s[2], s = "acbd"
 * 交换 s[1] 和 s[2], s = "abcd"
 * 示例 3：
 *
 * 输入：s = "cba", pairs = [[0,1],[1,2]]
 * 输出："abc"
 * 解释：
 * 交换 s[0] 和 s[1], s = "bca"
 * 交换 s[1] 和 s[2], s = "bac"
 * 交换 s[0] 和 s[1], s = "abc"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s 中只含有小写英文字母
 * @author: zww
 * @date: 2021/1/11
 * @version: V1.0
 */
public class SmallestStringWithSwaps {
    public static void main(String[] args) {
        System.out.println(smallestStringWithSwaps("dcab",Arrays.asList(Arrays.asList(0,3),Arrays.asList(1,2),Arrays.asList(0,2))));
    }
    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int[] parent = new int[s.length()];
        int[] rank = new int[s.length()];
        Arrays.fill(rank,1);
        for (int i = 0; i < s.length(); i++) {
            parent[i] = i;
        }
        for (List<Integer> pair : pairs) {
            union(pair.get(0),pair.get(1),parent,rank);
        }
        Map<Integer,List<Character>> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int key = find(i, parent);
            if(!charMap.containsKey(key)){
                charMap.put(key,new ArrayList<>());
            }
            charMap.get(key).add(s.charAt(i));

        }
        for (Map.Entry<Integer,List<Character>> entry:charMap.entrySet()){
            entry.getValue().sort((o1, o2) -> o2-o1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
           List<Character> list =  charMap.get(find(i,parent));
            stringBuilder.append(list.remove(list.size()-1));
        }
        return stringBuilder.toString();
    }
    public static int find(int x,int[] parent){
        if(parent[x]!=x){
            parent[x] = find(parent[x],parent);
        }
        return parent[x];
    }
    public static void union(int x,int y,int[] parent,int[] rank){
        int rootX = find(x, parent);
        int rootY = find(y, parent);
        if (rootX == rootY) {
            return;
        }
        if(rank[rootX]<rank[rootY]){
            int temp = rootX;
            rootX = rootY;
            rootY = temp;
        }
        rank[rootX]+=rank[rootY];
        parent[rootY] = rootX;
    }
}
