import java.util.*;

/**
 * @description: 316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 * <p>
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * @author: zww
 * @date: 2020/11/16
 * @version: V1.0
 */
public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("ccacbaba"));
    }

    public static String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        HashSet<Character> used = new HashSet<>(map.size());
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (used.contains(s.charAt(i))) {
                continue;
            }
            used.add(s.charAt(i));
            while (!deque.isEmpty() && s.charAt(i) <= deque.peekLast() && map.get(deque.peekLast()) > i) {
                used.remove(deque.pollLast());
            }
            deque.offerLast(s.charAt(i));
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!deque.isEmpty()) {
            stringBuilder.append(deque.pollFirst());
        }
        return stringBuilder.toString();
    }
}
