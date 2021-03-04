package slidingwindow;

/**
 * @description:
 * 978. 最长湍流子数组
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 *
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 *
 * 返回 A 的最大湍流子数组的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 * 示例 2：
 *
 * 输入：[4,8,12,16]
 * 输出：2
 * 示例 3：
 *
 * 输入：[100]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 * @author: zww
 * @date: 2021/2/8
 * @version: V1.0
 */
public class MaxTurbulenceSize {
    public static void main(String[] args) {
        System.out.println(maxTurbulenceSize(new int[]{4,4,4,4,4,4}));
    }
    public static int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int start = 0;
        int reverse = 0;
        int ret = 1;
        for (int i = 1; i < n; i++) {
            if(arr[i] == arr[i-1]){
                ret = Math.max(i-start,ret);
                start = i;
                continue;
            }
            int c = arr[i] > arr[i - 1] ? 1 : -1;
            if (reverse == 0 || c + reverse == 0) {
                ret = Math.max(i - start + 1, ret);
            } else {
                ret = Math.max(i - start, ret);
                start = i - 1;
            }
            reverse = c;
        }
        return ret;
    }
}
