package zzz_everyday;

import java.util.Arrays;

public class Rob2 {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(robrob(nums, 0, nums.length - 1), robrob(nums, 1, nums.length));
    }

    public int robrob(int[] nums, int start, int end){
        int[] dp = new int [nums.length+1];
        dp[start] = 0;
        dp[start + 1] = nums[start];
        for(int i = start + 2;i <= end;i++){
            dp[i]= Math.max(dp[i-2]+nums[i-1], dp[i-1]);
        }
        return dp[end];
    }
}
