package template;

public class Window {
    // 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数。
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int len = nums.length;
        int ans = 0;
        while(right < len){
            if(nums[right] == 0) k--;
            right++;
            while(k < 0) {
                if(nums[left] == 0) k++;
                left++;
            }
            ans = Math.max(ans, right-left);
        }
        return ans;
    }
}
