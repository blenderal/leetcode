/**
 * @description:
 * @author: zww
 * @date: 2021/4/8
 * @version: V1.0
 */
public class BinarySearch {
    public static void main(String[] args) {
//        System.out.println(bs(null, 3));
    }

    public static int bs(int[] nums,int target){
        int right = nums.length-1;
        int left = 0;
        while (left <= right){
            int mid = (left+right)/2;
            if(target>nums[mid]){
                left = mid+1;
            }else if(target<nums[mid]){
                right = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    public void update(int[] nums){
        synchronized (this){
            nums[1] = 0;
        }
    }

}
