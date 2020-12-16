/**
 * @description:
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：0
 *
 *
 * 提示：
 *
 * 0 <= n <= 5 * 10^6
 * @author: zww
 * @date: 2020/12/3
 * @version: V1.0
 */
public class CountPrimes {
    public static void main(String[] args) {
        // TODO
        System.out.println(countPrimes(499979));
    }
    public static int countPrimes(int n) {
        int result = 0;
        if (n < 2) {
            return 0;
        }
        int[] nums = new int[n];
        for (int i = 2; i < n; i++) {
            if (nums[i] != 0) {
                continue;
            }
            result++;
            long j = i;
            while (i * j < n) {
                nums[(int) (i * j)] = 1;
                j++;
            }
        }
        return result;
    }
}
