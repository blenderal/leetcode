package array;

/**
 * @description:
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 *
 * 提示：
 *
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * @author: niwei
 * @since: 2022/3/22
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        while (true) {
            int i = partition(nums, l, r);
            if (i == nums.length - k) {
                return nums[i];
            } else if (i < nums.length - k) {
                l = i+1;
            } else {
                r = i-1;
            }
        }
    }
    public int partition(int[] nums,int l,int r){
        int pivot = nums[l];
        int i = l;
        for (int j = i+1; j <= r; j++) {
            if(nums[j] < pivot){
                swap(nums,++i,j);
            }
        }
        swap(nums,l,i);
        return i;
    }

    public void swap(int[] nums,int i,int j){
        if(i == j){
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
