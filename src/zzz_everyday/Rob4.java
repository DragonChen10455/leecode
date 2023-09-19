package zzz_everyday;

import java.util.Arrays;

public class Rob4 {
    public int rob4(int[] nums, int k) {
        int low = 1, high = Arrays.stream(nums).max().getAsInt();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canStealKHouses(nums, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public boolean canStealKHouses(int[] nums, int k, int capability) {
        int count = 0;
        int n = nums.length;
        int prev = -2;
        for (int i = 0; i < n && count < k; i++) {
            if (i - prev >= 2 && nums[i] <= capability) {
                count++;
                prev = i;
            }
        }
        return count >= k;
    }
}
