import java.util.HashMap;
import java.util.Map;

/**
 * @description: 454. 四数相加 II
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。
 * <p>
 * 例如:
 * <p>
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * @author: zww
 * @date: 2020/11/27
 * @version: V1.0
 */
public class FourSumCount {
    public static void main(String[] args) {
        System.out.println(fourSumCount(
                new int[]{1, 2},
                new int[]{-2, -1},
                new int[]{-1, 2},
                new int[]{0, 2}));
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : A) {
            for (int i : B) {
                map.put(value + i, map.containsKey(value + i) ? map.get(value + i) + 1 : 1);
            }
        }
        for (int value : C) {
            for (int i : D) {
                if (map.containsKey(-(value + i))) {
                    result += map.get(-(value + i));
                }
            }
        }
        return result;
    }
}
