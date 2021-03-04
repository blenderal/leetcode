/**
 * @description:
 * 304. 二维区域和检索 - 矩阵不可变
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 *
 * Range Sum Query 2D
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 * 示例:
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * 说明:
 *
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2。
 * @author: zww
 * @date: 2021/3/2
 * @version: V1.0
 */
public class NumMatrix {
    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}

        });
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }
    private int[][] matrixSum;
    public NumMatrix(int[][] matrix) {
        int h = matrix.length;
        if(h == 0){
            return;
        }
        int w = matrix[0].length;
        matrixSum = new int[h][w];
        matrixSum[0][0] = matrix[0][0];
        for (int i = 1; i < w; i++) {
            matrixSum[0][i] = matrixSum[0][i-1]+matrix[0][i];
        }
        for (int i = 1; i < h; i++) {
            matrixSum[i][0] = matrixSum[i-1][0]+matrix[i][0];
        }
        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                matrixSum[i][j] = matrixSum[i][j-1]+matrixSum[i-1][j]-matrixSum[i-1][j-1]+matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 == 0 && col1 == 0){
            return matrixSum[row2][col2];
        }
        if(row1 == 0){
            return matrixSum[row2][col2]-matrixSum[row2][col1-1];
        }
        if(col1 == 0){
            return matrixSum[row2][col2]-matrixSum[row1-1][col2];
        }
        return matrixSum[row2][col2] -(matrixSum[row1-1][col2]+matrixSum[row2][col1-1]-matrixSum[row1-1][col1-1]);
    }
//    private int[][] matrixSum;
//    public NumMatrix(int[][] matrix) {
//        int h = matrix.length;
//        if(h == 0){
//            return;
//        }
//        int w = matrix[0].length;
//        matrixSum = new int[h+1][w+1];
//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < w; j++) {
//                matrixSum[i+1][j+1] = matrixSum[i+1][j]+matrixSum[i][j+1]-matrixSum[i][j]+matrix[i][j];
//            }
//        }
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        return matrixSum[row2+1][col2+1] -(matrixSum[row1][col2+1]+matrixSum[row2+1][col1]-matrixSum[row1][col1]);
//    }
}
