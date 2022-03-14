package array;

/**
 * @description: 334. 递增的三元子序列
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 数学表达式如下:
 *
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 *
 * 输入: [5,4,3,2,1]
 * 输出: false
 * @author: zww
 * @date: 2020/7/27
 * @version: V1.0
 */
public class IncreasingTriplet {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,-2,6};
        System.out.println(increasingTriplet(nums));
    }

    /**
     * 保存两个最小的数，一旦遍历到比次小的数还大的数则说明该序列存在递增的三元子序列
     */
    public static boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sec = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num <= sec) {
                sec = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
