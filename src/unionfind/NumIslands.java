package unionfind;

/**
 * @description:
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 * @author: niwei
 * @since: 2022/3/14
 */
public class NumIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        System.out.println(numIslands(grid));

    }

    public static int numIslands(char[][] grid) {
        int[][] number = new int[grid.length][grid[0].length];
        int iNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    number[i][j] = ++iNum;
                }
            }
        }
        int[] p = new int[iNum+1];
        for (int i = 0; i < iNum+1; i++) {
            p[i] = i;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '0'){
                    continue;
                }
                if(i != 0 && grid[i-1][j] == '1'){
                    if(union(p,number[i-1][j],number[i][j])){
                        iNum--;
                    }
                }
                if(j!=0 && grid[i][j-1] == '1'){
                    if(union(p,number[i][j-1],number[i][j])){
                        iNum--;
                    }
                }
            }
        }
        return iNum;

    }

    public static int findP(int[] p, int y){
        if (p[y] != y){
            p[y] = findP(p,p[y]);
        }
        return p[y];
    }

    public static boolean union(int[] p ,int x ,int y){
        int rootX = findP(p,x);
        int rootY = findP(p,y);
        if(rootX != rootY){
            p[rootX] = rootY;
            return true;
        }
        return false;
    }
}
