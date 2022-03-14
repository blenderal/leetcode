import java.util.Map;

/**
 * @description:
 * 264. 丑数 II
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 *
 *
 * 提示：
 *
 * 1 <= n <= 1690
 * @author: zww
 * @date: 2021/4/11
 * @version: V1.0
 */
public class NthUglyNumber {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(11));
    }
    public  static int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        int p2 = 1; int p3 = 1; int p5 = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3),dp[p5]*5);
            if(dp[p2]*2== dp[i]){
                p2++;
            }
            if(dp[p3]*3 == dp[i]){
                p3++;
            }
            if(dp[p5]*5 == dp[i]){
                p5++;
            }
        }
        return dp[n];
    }
}
