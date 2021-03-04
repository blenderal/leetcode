package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * 992. K 个不同整数的子数组
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
 *
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 *
 * 返回 A 中好子数组的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,2,1,2,3], K = 2
 * 输出：7
 * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * 示例 2：
 *
 * 输入：A = [1,2,1,3,4], K = 3
 * 输出：3
 * 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= A.length
 * 1 <= K <= A.length
 * @author: zww
 * @date: 2021/2/9
 * @version: V1.0
 */
public class SubarraysWithKDistinct {
    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{2,1,1,2,2,1,8,5,7,4,3,2,1,3,6,8,8,9,2},3));
    }
    public static int subarraysWithKDistinct(int[] A, int K) {
        int n = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        int ret =  0;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (map.size() < K) {
                map.put(A[right], map.containsKey(A[right]) ? map.get(A[right]) + 1 : 1);
                right++;
            }
            while (map.size() == K){
                ret++;
                int temp = right;
                while (temp <n && map.containsKey(A[temp++])){
                    ret++;
                }
                map.put(A[left], map.get(A[left]) - 1);
                if(map.get(A[left])== 0){
                    map.remove(A[left]);
                }
                left++;
            }
        }
        return ret;
    }
}
