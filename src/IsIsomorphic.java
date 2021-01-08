import java.util.HashMap;

/**
 * @description: 205. 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 * @author: zww
 * @date: 2020/12/27
 * @version: V1.0
 */
public class IsIsomorphic {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        int length = t.length();
        for (int i = 0; i < length; i++) {
            int compare = t.charAt(i) - s.charAt(i);
            if (map1.containsKey(t.charAt(i)) && compare != map1.get(t.charAt(i))) {
                return false;
            }
            if (map2.containsKey(s.charAt(i)) && compare != map2.get(s.charAt(i))) {
                return false;
            }
            map1.put(t.charAt(i), compare);
            map2.put(s.charAt(i), compare);
        }
        return true;
    }
}
