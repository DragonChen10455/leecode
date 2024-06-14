package zzz_everyday;

public class MaxScore {
    public static long maxScore(int[] nums, int x) {
        int n = nums.length;
        long odd = 0L;
        long even = 0L;
        long res = nums[0];
        if(nums[0] % 2 == 0){
            even = nums[0];
            odd = Integer.MIN_VALUE;
        } else {
            even = Integer.MIN_VALUE;
            odd = nums[0];
        }
        for(int i = 1;i < n;i++){
            if(nums[i] % 2 == 0) {
                even = Math.max(odd + nums[i] - x, even + nums[i]);
            }
            else {
                odd = Math.max(even + nums[i] - x, odd + nums[i]);
            }
            res = Math.max(res, Math.max(odd, even));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,1,9,2};
        System.out.println(maxScore(nums, 5));
    }
}
