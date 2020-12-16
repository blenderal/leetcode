/**
 * @description: 659. 分割数组为连续子序列
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
 * <p>
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 * <p>
 * <p>
 * 提示：
 * <p>
 * 输入的数组长度范围为 [1, 10000]
 * @author: zww
 * @date: 2020/12/4
 * @version: V1.0
 */
public class IsPossible {
    public static void main(String[] args) {
        // TODO
        System.out.println(isPossible(new int[]{3, 4, 4, 5, 6, 7, 8, 9, 10, 11}));
    }

    public static boolean isPossible(int[] nums) {
        int l = nums.length;
        if (l < 3) {
            return false;
        }
        int r = nums[l - 1] - nums[0];
        int[] count = new int[r + 1];
        for (int num : nums) {
            count[num - nums[0]]++;
        }
        int[] end = new int[r + 1];
        for (int num : nums) {
            int index = num - nums[0];
            if (count[index] < 1) {
                continue;
            }
            if (index != 0 && end[index - 1] != 0) {
                count[index]--;
                end[index - 1]--;
                end[index]++;
            } else {
                if (index <= r - 2 && count[index + 1] > 0 && count[index + 2] > 0) {
                    end[index + 2]++;
                    count[index]--;
                    count[index + 1]--;
                    count[index + 2]--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
