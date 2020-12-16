/**
 * @description:
 * 321. 拼接最大数
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 *
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 *
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 *
 * 示例 1:
 *
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * 示例 2:
 *
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * 示例 3:
 *
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 * @author: zww
 * @date: 2020/12/2
 * @version: V1.0
 */
public class MaxNumber {
    public static void main(String[] args) {
        int[] result = maxNumber(new int[]{2,1,7,8,0,1,7,3,5,8,9,0,0,7,0,2,2,7,3,5,5},
                new int[]{2,6,2,0,1,0,5,4,5,5,3,3,3,4},35);
        // TODO
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[]{0};
        for (int i = 0; i <= k; i++) {
            if (i > nums1.length||k - i > nums2.length) {
                continue;
            }
            int[] max1 = getMax(nums1, i);
            int[] max2 = getMax(nums2,k-i);
            int[] max = new int[k];
            int x = max1.length, y = max2.length;
            if (x == 0) {
                max = max2;
                result = compare(result, 0, max, 0) < 0 ? max : result;
                continue;
            }
            if (y == 0) {
                max = max1;
                result = compare(result, 0, max, 0) < 0 ? max : result;
                continue;
            }
            int index1 = 0, index2 = 0;
            for (int j = 0; j < k; j++) {
                if (compare(max1, index1, max2, index2) > 0) {
                    max[j] = max1[index1++];
                } else {
                    max[j] = max2[index2++];
                }
            }
            result = compare(result,0,max,0)<0?max:result;
        }
        return result;
    }

    private static int[] getMax(int[] nums, int remain) {
        int[] result = new int[remain];
        if(remain == nums.length){
            return nums;
        }
        int remove = nums.length-remain;
        if(remove == nums.length){
            return new int[]{};
        }
        int count = 0;
        int top = -1;
        for (int num : nums) {
            while (top >= 0 && result[top] < num && count < remove) {
                top--;
                count++;
            }
            if (top < remain - 1) {
                result[++top] = num;
            } else {
                count++;
            }
        }
        return result;
    }

    public static int compare(int[] num1, int index1, int[] num2, int index2) {
        int x = num1.length, y = num2.length;
        while (index1 < x && index2 < y) {
            int difference = num1[index1] - num2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2);
    }
}
