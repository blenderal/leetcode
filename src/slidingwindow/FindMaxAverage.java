package slidingwindow;

/**
 * @description:
 * 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 *
 * 提示：
 *
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 * @author: zww
 * @date: 2021/2/4
 * @version: V1.0
 */
public class FindMaxAverage {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
    }
    public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        double maxAvg = (double) windowSum / k;
        for (int i = k; i < n; i++) {
            windowSum += nums[i];
            windowSum -= nums[i - k];
            maxAvg = Math.max(maxAvg, (double) windowSum / k);
        }
        return maxAvg;
    }
}
