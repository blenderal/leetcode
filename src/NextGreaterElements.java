import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description:
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 * @author: zww
 * @date: 2021/3/6
 * @version: V1.0
 */
public class NextGreaterElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{
                2,3,4,5,6,3,5,7,8,1,2,4,6
        })));
    }
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] next  = new int[n];
        Arrays.fill(next,-1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <nums[i%n]){
                next[stack.pop()] = nums[i%n];
            }
            stack.push(i%n);
        }
        return next;
    }
}
