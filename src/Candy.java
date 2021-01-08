/**
 * @description: 135. 分发糖果
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 * <p>
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * @author: zww
 * @date: 2020/12/24
 * @version: V1.0
 */
public class Candy {
    public static void main(String[] args) {
        int[] num = new int[]{2, 1, 2, 3, 2, 1, 3, 2, 1, 2, 3, 4, 5, 6, 7, 4, 3, 2, 1, 1, 2, 3, 2, 1, 2, 3, 1, 2, 1, 2, 3, 4, 5, 6, 2, 1, 2, 1};
        int result = 0;
        for (int i = 0; i <num.length ; i++) {
            result+=num[i];
        }
        System.out.println(result);
        System.out.println(candy(new int[]{1, 0, 2, 3, 2, 1, 3, 2, 1, 4, 5, 6, 7, 8, 9, 7, 5, 4, 3, 3, 4, 5, 3, 2, 5, 7, 2, 4, 2, 3, 4, 5, 6, 9, 2, 1, 5, 3}));
    }

    public static int candy(int[] ratings) {
        int length = ratings.length;
        int result = 0;
        int repeat = 0;
        for (int i = 1; i < length; ) {
            int left = 0;
            while (i < length && ratings[i] > ratings[i - 1]) {
                left++;
                result += left;
                i++;
            }
            int right = 0;
            while (i < length && ratings[i] < ratings[i - 1]) {
                right++;
                result += right;
                i++;
            }
            while (i < length && ratings[i] == ratings[i - 1]) {
                result += 1;
                i++;
            }
            result += Math.max(left + 1, right + 1) - repeat;
            repeat = 1;
        }
        return length == 1 ? 1 : result;
    }
}
