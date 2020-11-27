package Array;

import java.util.Arrays;

/**
 * @description: 164. 最大间距
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * <p>
 * 如果数组元素个数小于 2，则返回 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 * <p>
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * 说明:
 * <p>
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 * @author: zww
 * @date: 2020/7/28
 * @version: V1.0
 */
public class MaximumGap {
    public static void main(String[] args) {
        System.out.println(maximumGap(
                new int[]{1,2}));
    }

    public static int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        int bucketSize = Math.max((max - min) / (nums.length - 1),1);
        int bucketLength = (max - min) / bucketSize + 1 ;
        int[][] bucket = new int[bucketLength][2];
        for (int i = 0; i < bucketLength; i++) {
            bucket[i][0] =bucket[i][1] =  -1;
        }
        for (int num : nums) {
            int index = (num - min) / bucketSize;
            if (bucket[index][0] == -1) {
                bucket[index][0] = bucket[index][1] = num;
                continue;
            }
            bucket[index][0] = Math.min(bucket[index][0],num);
            bucket[index][1] = Math.max(bucket[index][1],num);
        }
        int result = 0;
        int pre = 0;
        for (int i = 1; i < bucketLength; i++) {
            if(bucket[i][0] == -1){
                continue;
            }
            if (bucket[i][0] - bucket[pre][1] > result) {
                result = bucket[i][0] - bucket[pre][1];
            }
            pre = i;
        }
        return result;
    }
}
