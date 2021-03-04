import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * 119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * @author: zww
 * @date: 2021/2/12
 * @version: V1.0
 */
public class GetRow {
    public static void main(String[] args) {
        System.out.println(getRow(0));
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();
        ret.add(1);
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                if (j == i) {
                    ret.add(j, 1);
                } else {
                    ret.set(j, ret.get(j) + ret.get(j - 1));
                }
            }
        }
        return ret;
    }
}
