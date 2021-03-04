/**
 * @description:
 * 485. 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 *
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 * @author: zww
 * @date: 2021/2/15
 * @version: V1.0
 */
public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,1,0,1,1,1,0,0,1,1,1,1}));
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int ret = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 1) {
                count++;
            }else {
                ret = Math.max(ret,count);
                count = 0;
            }
        }
        return Math.max(ret,count);
    }
}
