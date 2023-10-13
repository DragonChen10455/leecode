package zzz_everyday;

public class FindTheArrayConcVal {
    public long findTheArrayConcVal(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        long ans = 0;
        while(start < end) {
            ans += Integer.parseInt(String.valueOf(nums[start]) + String.valueOf(nums[end]));
            start++;
            end--;
        }
        if(start == end){
            ans += nums[start];
        }
        return ans;
    }
}
