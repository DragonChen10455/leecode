package zzz_everyday;

import java.util.*;

public class MinimumAddedInteger {
    public static int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int m = nums2.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int skip = i;
            if(skip > 2){
                break;
            }
            int delta = nums2[0] - nums1[i];
            int idx = i + 1;
            for(int j = 1;j < m;j++) {
                while(idx + j - 1 < n && nums2[j] - nums1[idx + j - 1] != delta){
                    skip++;
                    idx++;
                }
            }
            if (skip <= 2) {
                ans = Math.min(ans, delta);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,7,5};
        int[] nums2 = {5};
        System.out.println(minimumAddedInteger(nums1, nums2));
    }
}
