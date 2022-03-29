package array;

import java.util.Random;

/**
 * @description: 912. 排序数组
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 * @author: niwei
 * @since: 2022/3/29
 */
public class SortArray {
    public int[] sortArray(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        quickSort(nums, l, r);
        return nums;
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int i = randomizePartition(nums, l, r);
            quickSort(nums, l, i - 1);
            quickSort(nums, i + 1, r);
        }
    }

    public int randomizePartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; j++) {
            if (nums[j] <= pivot) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, r, ++i);
        return i;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
