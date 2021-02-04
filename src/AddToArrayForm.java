import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: 989. 数组形式的整数加法
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * <p>
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 示例 2：
 * <p>
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 * <p>
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 * <p>
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 * @author: zww
 * @date: 2021/1/22
 * @version: V1.0
 */
public class AddToArrayForm {
    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9}, 1));
    }

    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> ret = new ArrayList<>();
        String s = String.valueOf(K);
        int l1 = A.length;
        int l2 = s.length();
        int l = Math.max(l1, l2);
        int step = 0;
        for (int i = 0; i < l; i++) {
            int num = step;
            if (i < l1) {
                num += A[l1 - i - 1];
            }
            if (i < l2) {
                num += s.charAt(l2 - i - 1) - '0';
            }
            ret.add( num > 9 ? num - 10 : num);
            step = num > 9 ? 1 : 0;

        }
        if(step != 0){
            ret.add(step);
        }
        Collections.reverse(ret);
        return ret;

    }
}
