import java.util.ArrayList;
import java.util.List;

/**
 * @description: 842. 将数组拆分成斐波那契序列
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 * <p>
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 * <p>
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 * <p>
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："123456579"
 * 输出：[123,456,579]
 * 示例 2：
 * <p>
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 * 示例 3：
 * <p>
 * 输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成。
 * 示例 4：
 * <p>
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 * 示例 5：
 * <p>
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11,0,11,11] 也同样被接受。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 200
 * 字符串 S 中只含有数字。
 * @author: zww
 * @date: 2020/12/8
 * @version: V1.0
 */
public class SplitIntoFibonacci {
    public static void main(String[] args) {
        System.out.println(splitIntoFibonacci("11235813"));
    }

    public static List<Integer> splitIntoFibonacci(String S) {
        List<Integer> result = new ArrayList<>();
        // TODO
        backtrack(S, result, S.length(),0,0,0);
        return result;
    }

    public static boolean backtrack(String S, List<Integer> list, int length, int sum, int index, int pre) {
        if (index == length) {
            return list.size() >= 3;
        }
        long currentLong = 0;
        for (int i = index; i < length; i++) {
            //两位数以上且首位数为0直接返回；
            if (i > index && S.charAt(index) == '0') {
                return false;
            }
            currentLong = currentLong * 10 + S.charAt(i) - '0';
            // 组成的数字超过最大值直接返回失败
            if (currentLong > Integer.MAX_VALUE) {
                return false;
            }
            int current = (int) currentLong;
            if (list.size() >= 2) {
                // 组成的数字大于前两个值之和 证明在拼接只会越来越大直接返回失败
                if (current > sum) {
                    return false;
                    // 组成的数字大于前两个值之和可以继续尝试拼接
                } else if (current < sum) {
                    continue;
                }
            }
            list.add(current);
            // 继续拼接之后的数字
            if (backtrack(S, list, length, pre + current, i + 1, current)) {
                return true;
            } else {
                // 移除错误项
                list.remove(list.size() - 1);
            }

        }
        return false;
    }

}
