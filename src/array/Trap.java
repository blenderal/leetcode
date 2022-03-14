package array;

/**
 * @description:
 *
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * @author: zww
 * @date: 2020/7/27
 * @version: V1.0
 */
public class Trap {
    public static void main(String[] args) {
        int[] height = new int[]{1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        if(height.length==0){
            return 0;
        }
        int max = 0;
        int total = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= height[max]) {
                max = i;
            }
            total += height[i];
        }
        int overTotal = 0;
        int min = 0;
        for (int i = 0; i <= max; i++) {
            if (height[i] > min) {
                min = height[i];
                overTotal += height[i];
            } else {
                overTotal += min;
            }

        }
        min = 0;
        for (int i = height.length - 1; i > max; i--) {
            if (height[i] > min) {
                min = height[i];
                overTotal += height[i];
            } else {
                overTotal += min;
            }
        }
        return overTotal - total;
    }
}
