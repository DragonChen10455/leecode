package zzz_everyday;

import java.util.*;

public class LargestNumber {
    public static String largestNumber(int[] nums) {
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        String[] strs = new String[n];
        for(int i = 0;i < n;i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        for(int i = strs.length - 1;i >= 0;i--){
            sb.append(strs[i]);
        }
        int k = 0;
        while (k < sb.length() - 1 && sb.charAt(k) == '0') k++;
        return sb.substring(k);
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }
}
