package Array;

import java.util.HashSet;

/**
 * @description: 128. 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * @author: zww
 * @date: 2020/7/28
 * @version: V1.0
 */
public class LongestConsecutive {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    /**
     * 用hash查找可以将查找时间缩短为O(1)
     * 从n-1开始找，避免存在重复查找
     */
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int longest = 0;
        for (int num : nums) {
            hashSet.add(num);
        }
        for (Integer num: hashSet){
            int longestCurrent  = 1;
            if(hashSet.contains(num-1)){
                continue;
            }
            while (hashSet.contains(++num)){
                longestCurrent++;
            }
            longest = Math.max(longest,longestCurrent);
        }
        return longest;
    }
}
