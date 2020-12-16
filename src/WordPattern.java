import java.util.HashMap;
import java.util.Map;

/**
 * @description: 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 * @author: zww
 * @date: 2020/12/16
 * @version: V1.0
 */
public class WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("abaa", "dog dog cat dog"));
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        char[] patterns = pattern.toCharArray();
        String[] strings = s.split(" ");
        int length = patterns.length;
        if (length != strings.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            // 字符串和pattern都未出现过，则记录
            if (!map1.containsKey(patterns[i]) && !map2.containsKey(strings[i])) {
                map1.put(patterns[i], strings[i]);
                map2.put(strings[i], patterns[i]);
                continue;
            }
            // pattern出现过，比对出现过的pattern对应的字符串是否与当前字符串相同
            if (map1.containsKey(patterns[i]) && !map1.get(patterns[i]).equals(strings[i])) {
                return false;
            }
            // 字符串出现过，比对出现过的字符串对应的pattern是否与当前pattern相同
            if (map2.containsKey(strings[i]) && map2.get(strings[i]) != patterns[i]) {
                return false;
            }

        }
        return true;
    }
}
