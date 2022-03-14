/**
 * @description:
 * 面试题 17.21. 直方图的水量
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * @author: zww
 * @date: 2021/4/2
 * @version: V1.0
 */
public class Trap {
    public static void main(String[] args) {
        Trap trap = new Trap();
        System.out.println(trap.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
    public int trap(int[] height) {
        int n = height.length;
        int maxIndex = 0;
        int result = 0;
        for (int i = 1; i < n; i++) {
            if(height[i]>height[maxIndex]){
                maxIndex = i;
            }
        }
        int max = -1;
        for (int i = 0; i < maxIndex; i++) {
            if(height[i] > max){
                max = height[i];
            }else {
                result+=max-height[i];
            }
        }
        max = -1;
        for (int i = n-1; i > maxIndex; i--) {
            if(height[i] > max){
                max = height[i];
            }else {
                result+=max-height[i];
            }
        }
        return result;
    }
}
