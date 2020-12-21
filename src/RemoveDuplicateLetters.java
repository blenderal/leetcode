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
        System.out.println(removeDuplicateLetters("ecbacba"));
    }

    public static String removeDuplicateLetters(String s) {
        int length = s.length();
        int[] last = new int[26];
        boolean[] used = new boolean[26];
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            // 栈中已有直接抛弃
            if (used[c - 'a']) {
                continue;
            }
            // 比栈顶小且栈顶后方还有重复则弹出栈顶
            while (sb.length() > 0 && c < sb.charAt(sb.length() - 1) && last[sb.charAt(sb.length() - 1) - 'a'] > i) {
                used[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c);
            used[c - 'a'] = true;
        }
        return sb.toString();


//
//        int length = s.length();
//        Map<Character,Integer> map = new HashMap<>();
//        Set<Character> set =new HashSet<>();
//        for (int i = 0; i < length; i++) {
//            map.put(s.charAt(i),i);
//        }
//        Deque<Character> stack = new LinkedList<>();
//        for (int i = 0; i < length; i++) {
//            char c = s.charAt(i);
//            // 栈中已有直接抛弃
//            if(set.contains(c)){
//                continue;
//            }
//            // 比栈顶小且栈顶后方还有重复则弹出栈顶
//            while (!stack.isEmpty() && c < stack.peekLast() && map.get(stack.peekLast()) > i) {
//                set.remove(stack.pollLast());
//            }
//            stack.offerLast(c);
//            set.add(c);
//        }
//        StringBuilder sb = new StringBuilder();
//        while (!stack.isEmpty()){
//            sb.append(stack.pollFirst());
//        }
//        return sb.toString();
    }
}
