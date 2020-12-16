/**
 * @description:
 * 738. 单调递增的数字
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 * @author: zww
 * @date: 2020/12/15
 * @version: V1.0
 */
public class MonotoneIncreasingDigits {
    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(10));
    }
    public static int monotoneIncreasingDigits(int N) {
        String s = Integer.toString(N);
        int index = -1;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i+1) < s.charAt(i)) {
                while (i >= 1 && s.charAt(i) == s.charAt(i - 1)) {
                    i--;
                }
                index = i;
                break;
            }
        }
        if (index == -1) {
            return N;
        }
        int ten = (int) Math.pow(10, s.length() - index - 1);
        return N / ten * ten - 1;
    }
}
