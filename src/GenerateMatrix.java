import java.util.Arrays;

/**
 * @description:
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 20
 * @author: zww
 * @date: 2021/3/16
 * @version: V1.0
 */
public class GenerateMatrix {
    public static void main(String[] args) {
        GenerateMatrix generateMatrix = new GenerateMatrix();
        System.out.println(Arrays.deepToString(generateMatrix.generateMatrix(5)));
    }
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int left = -1,up = 0,right = n-1,down = n-1;
        int i = 1;
        int total = n*n;
        while (i<=total){
            int start = ++left;
            while (start <= right && i <= total) {
                result[up][start++] = i++;
            }
            start = ++up;
            while (start<=down&&i<=total){
                result[start++][right] = i++;
            }
            start = --right;
            while (start>=left&&i<=total){
                result[down][start--] = i++;
            }
            start = --down;
            while (start>=up&&i<=total){
                result[start--][left] =i++;
            }
        }
        return result;

    }
}
