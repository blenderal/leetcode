package slidingwindow;

/**
 * @description:
 * 395. 至少有K个重复字符的最长子串
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2：
 *
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由小写英文字母组成
 * 1 <= k <= 105
 * @author: zww
 * @date: 2021/2/27
 * @version: V1.0
 */
public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(longestSubstring("ababbc",2));
    }
    public static int longestSubstring(String s, int k) {
        return dfs(s,0,s.length()-1,k);
    }

    public static int dfs(String s,int l,int r,int k){
        if (r - l + 1 < k) {
            return 0;
        }
        int[] count = new int[26];
        for (int i = l; i <= r; i++) {
            count[s.charAt(i) - 'a']++;
        }
        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == 0) {
            return r - l + 1;
        }
        int i = l;
        int ret = 0;
        while (i <= r) {
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r) {
                break;
            }
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }
            ret = Math.max(ret, dfs(s, start, i - 1, k));
        }
        return ret;

    }
}
