package statck;

import sun.misc.Launcher;

import java.net.URL;
import java.util.Arrays;

/**
 * @description:
 * 1047. 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 *
 *
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 *
 * 提示：
 *
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 * @author: zww
 * @date: 2021/3/9
 * @version: V1.0
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));

    }
    public static String removeDuplicates(String S) {
//        Deque<Character> stack = new LinkedList<>();
//        int n = S.length();
//        for (int i = 0; i < n; i++) {
//            if(stack.isEmpty() || stack.peek() != S.charAt(i)){
//                stack.push(S.charAt(i));
//                continue;
//            }
//            while (!stack.isEmpty() && stack.peek() == S.charAt(i)){
//                stack.pop();
//            }
//        }
//        StringBuilder ret = new StringBuilder();
//        while (!stack.isEmpty()){
//            ret.append(stack.pollLast());
//        }
//        return ret.toString();

        StringBuilder ret = new StringBuilder();
        int n = S.length();
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            int lastIndex = ret.length() - 1;
            if (ret.length() > 0 && ret.charAt(lastIndex) == c) {
                ret.deleteCharAt(lastIndex);
            } else {
                ret.append(c);
            }
        }
        return ret.toString();
    }
}
