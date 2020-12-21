import com.sun.tools.javac.code.Attribute;

/**
 * @description: 389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 * <p>
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 * <p>
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 * @author: zww
 * @date: 2020/12/18
 * @version: V1.0
 */
public class FindTheDifference {
    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
    }
    public static char findTheDifference(String s, String t) {

        char result = 0;
        for (int i = 0; i < s.length(); i++) {
            result^=s.charAt(i);
            result^=t.charAt(i);
        }
        return (char)(result^t.charAt(t.length()-1));
    }
}
//        int[] map = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            map[s.charAt(i) - 'a']--;
//            map[t.charAt(i) - 'a']++;
//        }
//        map[t.charAt(t.length() - 1) - 'a']++;
//        char result = 'a';
//        for (int i = 0; i < map.length; i++) {
//            if (map[i] == 1) {
//                result = (char) (i + result);
//            }
//        }
//        return result;
