package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * @author: zww
 * @date: 2021/3/31
 * @version: V1.0
 */
public class SubsetsWithDup {
    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        System.out.println(subsetsWithDup.subsetsWithDup(new int[]{1,2,2}));
    }
    public List<List<Integer>> result = new ArrayList<>(new ArrayList<>());
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTracking(0, nums.length,new ArrayList<>(),nums);
        return result;
    }

    public void backTracking(int index, int n, List<Integer> path, int[] nums) {
        result.add(new ArrayList<>(path));
        if (index == n) {
            return;
        }
        for (int i = index; i < n; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backTracking(i + 1, n, path, nums);
            path.remove(path.size() - 1);
        }
    }
}
