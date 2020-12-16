/**
 * @description:
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 * @author: zww
 * @date: 2020/12/1
 * @version: V1.0
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] result = searchRange(new int[]{1},1);
        // TODO
        System.out.println(result[0]+","+result[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false) - 1;
        if (right >= 0 && left != nums.length && nums[right] == target) {
            return new int[]{left, right};
        } else {
            return new int[]{-1, -1};
        }
    }
    public static int binarySearch(int[] nums,int target,boolean contain){
        int lo = 0;
        int hi = nums.length-1;
        int ans = nums.length;
        while (lo<=hi){
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (contain && nums[mid] >= target)) {
                hi = mid - 1;
                ans = mid;
            } else {
                lo = mid + 1;
            }
        }
        return  ans;
    }
}
