/**
 * @description: 1232. 缀点成线
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 * <p>
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates 中不含重复的点
 * @author: zww
 * @date: 2021/1/17
 * @version: V1.0
 */
public class CheckStraightLine {
    public static void main(String[] args) {
        System.out.println(checkStraightLine(new int[][]{
                {1,2},
                {2,3},
                {3,4},
                {4,5},
                {5,6},
                {6,7}
        }));
    }
    public static boolean checkStraightLine(int[][] coordinates) {
        int length = coordinates.length;
        if (length == 2) {
            return true;
        }
        int x = coordinates[1][0] - coordinates[0][0];
        int y = coordinates[1][1] - coordinates[0][1];
        for (int i = 2; i < length; i++) {
            if ((coordinates[i][0] - coordinates[0][0]) * y != (coordinates[i][1] - coordinates[0][1]) * x) {
                return false;
            }
        }
        return true;
    }
}
