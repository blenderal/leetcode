import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * @author: zww
 * @date: 2020/11/16
 * @version: V1.0
 */
public class ReconstructQueue {
    public static void main(String[] args) {
        int[][] people = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        people = solve(people);
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i][0]+","+people[i][1]);
        }
    }
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });
        int[][] ans = new int[people.length][];
        for (int[] person : people) {
            int c = person[1] + 1;
            for (int i = 0; i < people.length; i++) {
                if (ans[i] == null) {
                    c--;
                }
                if (c == 0) {
                    ans[i] = person;
                    break;
                }
            }
        }
        return ans;
    }

    public static int[][] solve(int[][] people) {
        Arrays.sort(people,(o1, o2) -> {
            if(o1[0]!=o2[0]){
                return o2[0]-o1[0];
            }
            return o1[1]-o2[1];
        });
        List<int[]> ans = new ArrayList<>();
        for(int[] person:people){
            ans.add(person[1],person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
