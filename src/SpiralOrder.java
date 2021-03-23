import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * @author: zww
 * @date: 2021/3/15
 * @version: V1.0
 */
public class SpiralOrder {
    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        System.out.println(spiralOrder.spiralOrder(new int[][]{
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9,10,11,12},
//                {13,14,15,16}
                {1,2,3},
                {4,5,6},
                {7,8,9}
        }));
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length-1;
        int total = matrix.length * matrix[0].length;
        while (total > 0) {
            int index = left;
            while (index <= right && total > 0) {
                ret.add(matrix[up][index++]);
                total--;
            }
            index = ++up;
            while (index <= down && total > 0) {
                ret.add(matrix[index++][right]);
                total--;
            }
            index = --right;
            while (index >= left && total > 0) {
                ret.add(matrix[down][index--]);
                total--;
            }
            index = --down;
            while (index >= up && total > 0) {
                ret.add(matrix[index--][left]);
                total--;
            }
            ++left;
        }
        return ret;
    }
}
