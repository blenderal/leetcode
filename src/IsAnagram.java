import java.util.HashMap;

/**
 * @description:
 * @author: zww
 * @date: 2020/11/22
 * @version: V1.0
 */
public class IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("aacc","ccac"));
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.containsKey(s.charAt(i)) ? map.get(s.charAt(i)) + 1 : 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))||map.get(t.charAt(i)) < 1) {
                return false;
            }
            map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
        }
        return true;
    }
}
