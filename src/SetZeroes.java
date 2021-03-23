import java.util.Arrays;

/**
 * @description:
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 进阶：
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 示例 2：
 *
 *
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 * @author: zww
 * @date: 2021/3/21
 * @version: V1.0
 */
public class SetZeroes {
    public static void main(String[] args) {
        
        SetZeroes setZeroes = new SetZeroes();
        setZeroes.setZeroes(new int[][]{
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}

        });
    }
    public void setZeroes(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        boolean h0 = false;
        boolean w0 = false;
        for (int i = 0; i < h; i++) {
            if(matrix[i][0] == 0){
                h0 = true;
                break;
            }
        }
        for (int i = 0; i < w; i++) {
            if(matrix[0][i] == 0){
                w0 = true;
                break;
            }
        }

        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                if(matrix[i][j]==0){
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (h0) {
            for (int i = 0; i < h; i++) {
                matrix[i][0] = 0;
            }
        }
        if (w0) {
            for (int i = 0; i < w; i++) {
                matrix[0][i] = 0;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

//    public void setZeroes(int[][] matrix) {
//        int h = matrix.length;
//        int w = matrix[0].length;
//        int[] hZero = new int[h];
//        int[] wZero = new int[w];
//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < w; j++) {
//                if(matrix[i][j] == 0){
//                    hZero[i] = 1;
//                    wZero[j] = 1;
//                }
//            }
//        }
//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < w; j++) {
//                if(hZero[i] == 1 || wZero[j] == 1){
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//        System.out.println(Arrays.deepToString(matrix));
//    }
}
