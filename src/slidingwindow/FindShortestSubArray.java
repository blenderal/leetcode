package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * 697. 数组的度
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2：
 *
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 *
 *
 * 提示：
 *
 * nums.length 在1到 50,000 区间范围内。
 * nums[i] 是一个在 0 到 49,999 范围内的整数。
 * @author: zww
 * @date: 2021/2/20
 * @version: V1.0
 */
public class FindShortestSubArray {
    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{2,1,1,2,1,3,3,3,1,3,1,3,2}));
    }
    public static int findShortestSubArray(int[] nums) {
        int n = nums.length;
        Map<Integer,int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new int[]{i,i,1});
            }else {
               map.get(nums[i])[1] = i;
                map.get(nums[i])[2]++;
            }
        }
        int maxLength = 0;
        int shortestSub = 0;
        for(Map.Entry<Integer,int[]> entry:map.entrySet()){
            if(entry.getValue()[2]>maxLength){
                maxLength = entry.getValue()[2];
                shortestSub = entry.getValue()[1]-entry.getValue()[0]+1;
            }else if(entry.getValue()[2] == maxLength ){
                if(entry.getValue()[1]-entry.getValue()[0]+1<shortestSub){
                    shortestSub = entry.getValue()[1]-entry.getValue()[0]+1;
                }
            }
        }
        return shortestSub;
    }
}
