import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * @author: zww
 * @date: 2020/12/6
 * @version: V1.0
 */
public class Generate {
    public static void main(String[] args) {
        List<List<Integer>> result = generate(10);
        for (List<Integer> list:result) {
            for(Integer num:list){
                System.out.print(num+",");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if(j==0||j==i-1){
                    row.add(1);
                }else {
                    row.add(result.get(i-2).get(j-1)+result.get(i-2).get(j));
                }
            }
            result.add(row);
        }
        return result;
    }
}
