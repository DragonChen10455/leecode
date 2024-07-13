package zzz_everyday;

import java.util.*;

public class CanSortArray {
    public static boolean canSortArray(int[] nums) {
        int n = nums.length;
        for(int i = 0;i < n;){
            int start = i;
            int cnt = Integer.bitCount(nums[i++]);
            while(i < n && Integer.bitCount(nums[i]) == cnt){
                i++;
            }
            Arrays.sort(nums, start, i);
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {136,256,10};
        System.out.println(canSortArray(nums));
    }
}
