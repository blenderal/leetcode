package slidingwindow;

import java.util.*;

/**
 * @description:
 * 480. 滑动窗口中位数
 * 中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 *
 * 例如：
 *
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给你一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 *
 *
 *
 * 示例：
 *
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 *
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7      -1
 *  1  3 [-1  -3  5] 3  6  7      -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 *  因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 *
 *
 *
 * 提示：
 *
 * 你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。
 * 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。
 *
 * @author: zww
 * @date: 2021/2/3
 * @version: V1.0
 */
public class MedianSlidingWindow {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{1,4,2,3}, 4)));
    }
    public static double[] medianSlidingWindow(int[] nums, int k) {
        DualHeap dualHeap = new DualHeap(k);
        int n = nums.length;
        double[] ret = new double[n - k + 1];
        for (int i = 0; i < k; i++) {
            dualHeap.insert(nums[i]);
        }
        ret[0] = dualHeap.getMedian();
        for (int i = k; i < n; i++) {
            dualHeap.insert(nums[i]);
            dualHeap.delete(nums[i-k]);
            ret[i-k+1] = dualHeap.getMedian();
        }
        return ret;
    }
    static class DualHeap{
        private PriorityQueue<Integer> small;
        private PriorityQueue<Integer> large;
        private Map<Integer,Integer> delay;
        private int k;
        private int smallSize,largeSize;

        public DualHeap(int k) {
            this.k = k;
            this.small = new PriorityQueue<>(Comparator.reverseOrder());
            this.large = new PriorityQueue<>(Integer::compareTo);
            this.smallSize = 0;
            this.largeSize = 0;
            delay = new HashMap<>();
        }

        public void insert(int num){
            if(smallSize == 0 || num <= small.peek()){
                small.offer(num);
                smallSize++;
            }else {
                large.offer(num);
                largeSize++;
            }
            balance();
        }
        public void delete(int num){
            delay.put(num,delay.getOrDefault(num,0)+1);
            if(num <= small.peek()){
                smallSize--;
                if(num == small.peek()){
                    prune(small);
                }
            }else {
                largeSize--;
                if(num == large.peek()){
                    prune(large);
                }
            }
            balance();
        }

        public double getMedian() {
            return (k & 1) == 0 ? ((double) small.peek() + large.peek()) / 2 : (double) small.peek();
        }

        public void balance(){
            if(smallSize > largeSize+1){
                smallSize--;
                largeSize++;
                large.offer(small.poll());
                prune(small);

            }else if(smallSize < largeSize){
                smallSize++;
                largeSize--;
                small.offer(large.poll());
                prune(large);
            }
        }

        public void prune(PriorityQueue<Integer> priorityQueue) {
            while (!priorityQueue.isEmpty()) {
                int num = priorityQueue.peek();
                if (delay.containsKey(num)) {
                    priorityQueue.poll();
                } else {
                    break;
                }
                delay.put(num, delay.get(num) - 1);
                if (delay.get(num) == 0) {
                    delay.remove(num);
                }
            }
        }
    }
}
