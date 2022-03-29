package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * @author: niwei
 * @since: 2022/3/21
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3 || nums[0] > 0) {
            return result;
        }
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int r = nums.length - 1;
            for (int l = i + 1; l < nums.length - 1; l++) {
                if (l > i + 1 && nums[l] == nums[l - 1]) {
                    continue;
                }
                while (l < r && nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                }
                if (l == r) {
                    break;
                }
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> answer = new ArrayList<>();
                    answer.add(nums[i]);
                    answer.add(nums[l]);
                    answer.add(nums[r]);
                    result.add(answer);
                }
            }
        }
        return result;
    }
}
