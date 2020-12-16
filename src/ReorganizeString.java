/**
 * @description: 767. 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 * <p>
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 * <p>
 * S 只包含小写字母并且长度在[1, 500]区间内。
 * @author: zww
 * @date: 2020/11/30
 * @version: V1.0
 */
public class ReorganizeString {
    public static void main(String[] args) {
        // TODO
        System.out.println(reorganizeString("vvvlo"));

    }
    public static String reorganizeString(String S) {
        int l = (S.length() & 1) == 1 ? S.length() / 2 + 1 : S.length() / 2;
        int[] map = new int[26];
        int max = 0;
        for (int i = 0; i < S.length(); i++) {
            int index = S.charAt(i) - 'a';
            if (++map[index] > l) {
                return "";
            }
            if(map[index] >map[max]){
                max = index;
            }
        }
        int j = 0;
        char[] result = new char[S.length()];
        int i = 0;
        for (; i < S.length(); i += 2) {
            if (--map[max] < 0) {
                break;
            }
            result[i] = (char) (max + 'a');
        }
        for (;i < S.length(); i += 2) {
            while (--map[j] < 0) {
                j++;
            }
            result[i] = (char) (j + 'a');
        }
        i = 1;
        for (; i < S.length(); i += 2) {
            while (--map[j] < 0) {
                j++;
            }
            result[i] = (char) (j + 'a');
        }
        return new String(result);
    }

}
