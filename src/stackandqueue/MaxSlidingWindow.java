package stackandqueue;

import java.util.Arrays;

public class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        //总共有多少个窗口
        int len = nums.length - k + 1;
        //存放结果元素的数组
        int[] res = new int[len];
        MonotonicQueue monotonicQueue = new MonotonicQueue();
        //先将前k的元素放入队列
        for (int i = 0; i < k; i++) {
            monotonicQueue.add(nums[i]);
        }
        int num = 0;
        res[num++] = monotonicQueue.peek();
        for (int i = k; i < nums.length; i++) {
            //滑动窗口移除最前面的元素，移除是判断该元素是否放入队列
            monotonicQueue.poll(nums[i - k]);
            //滑动窗口加入最后面的元素
            monotonicQueue.add(nums[i]);
            //记录对应的最大值
            res[num++] = monotonicQueue.peek();
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
