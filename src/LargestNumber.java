import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:
 * 179. 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 *
 * 输入：nums = [10]
 * 输出："10"
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 * @author: zww
 * @date: 2021/4/12
 * @version: V1.0
 */
public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{111311, 1113}));
    }
    public static String largestNumber(int[] nums) {
//        List<String> list = new ArrayList<>();
//        for (int num : nums) {
//            list.add(String.valueOf(num));
//        }
//        list.sort((o1, o2) -> {
//            if (o1.startsWith(o2)||o2.startsWith(o1)) {
//                return (o2+o1).compareTo(o1+o2);
//            }
//            return o2.compareTo(o1);
//        });
//        StringBuilder sb = new StringBuilder();
//        for (String s : list) {
//            sb.append(s);
//        }
//        return sb.toString().startsWith("0") ? "0" : sb.toString();
        int n = nums.length;
        Integer[] integers = new Integer[n];
        for (int i = 0; i < n; i++) {
            integers[i] = nums[i];
        }
        Arrays.sort(integers, (o1, o2) -> {
            long sx = 10;
            long sy = 10;
            while (sx <= o1) {
                sx *= 10;
            }
            while (sy <= o2) {
                sy *= 10;
            }
            return (int) (o2*sx+o1-(o1*sy+o2));
        });
        if(integers[0] == 0){
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (Integer integer : integers) {
            result.append(integer);
        }
        return result.toString();
    }
}
