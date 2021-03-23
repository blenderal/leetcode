package dynamicprograming;

import java.util.Arrays;

/**
 * @description:
 * 132. 分割回文串 II
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 *
 * 返回符合要求的 最少分割次数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：0
 * 示例 3：
 *
 * 输入：s = "ab"
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 * @author: zww
 * @date: 2021/3/8
 * @version: V1.0
 */
public class MinCut {
    public static void main(String[] args) {
        System.out.println(minCut("aab"));
    }
    public static int minCut(String s) {
        int n = s.length();
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i],true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                g[i][j] = g[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (g[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 1; j <= i; j++) {
                    if (g[j][i]) {
                        f[i] = Math.min(f[j - 1] + 1, f[i]);
                    }
                }
            }
        }
        return f[n - 1];
    }
}
