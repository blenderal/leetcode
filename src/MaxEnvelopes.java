import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: 354. 俄罗斯套娃信封问题
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * <p>
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * <p>
 * 说明:
 * 不允许旋转信封。
 * <p>
 * 示例:
 * <p>
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * @author: zww
 * @date: 2021/3/4
 * @version: V1.0
 */
public class MaxEnvelopes {
    public static void main(String[] args) {
        System.out.println(maxEnvelopes(new int[][]{

//                {2, 3},
//                {3, 2},
//                {3, 1},
//                {3, 4},
//                {4, 5},
//                {5, 4},
//                {6, 4},
//                {6, 7}


                {2, 100},
                {3, 200},
                {4, 300},
                {5, 500},
                {5, 400},
                {5, 250},
                {6, 370},
                {6, 360},
                {7, 380}

//                {46,89},
//                {50,53},
//                {52,68},
//                {72,45},
//                {77,81}


        }));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (o1, o2) -> {
            if(o1[0] != o2[0]){
                return o1[0]-o2[0];
            }else {
                return o2[1]-o1[1];
            }
        });
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(envelopes[i][1]>envelopes[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret = Math.max(ret,dp[i]);
        }
        return ret;
    }
}
