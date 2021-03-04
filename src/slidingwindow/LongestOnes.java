package slidingwindow;

/**
 * @description:
 * 1004. 最大连续1的个数 III
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为 0 或 1
 * @author: zww
 * @date: 2021/2/19
 * @version: V1.0
 */
public class LongestOnes {
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},4));
    }
    public static int longestOnes(int[] A, int K) {
        int n = A.length;
        int left = 0;
        int right = 0;
//        int zeroCount = 0;
//        int ret = 0;
//        while (right < n) {
//            if (A[right] == 0) {
//                zeroCount++;
//                while (zeroCount > K) {
//                    if(A[left++] == 0){
//                        zeroCount--;
//                    }
//                }
//            }
//            ret = Math.max(ret, right - left + 1);
//            right++;
//        }
//        return ret;
        while (right<n){
            if(A[right++] == 0){
                K--;
            }
            if(K < 0 && A[left++] == 0){
                K++;
            }
        }
        return right-left;
    }
}
