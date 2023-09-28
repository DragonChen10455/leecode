package zzz_everyday;

import java.util.Arrays;

public class FullBloomFlowers {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] start = new int[flowers.length];
        int[] end = new int[flowers.length];
        for (int f = 0; f < flowers.length; f++) {
            start[f] = flowers[f][0];
            end[f] = flowers[f][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i = 0; i < people.length; i++) {
            people[i] = lowBound(start, people[i]+1) - lowBound(end, people[i]);
        }
        return people;
    }

    private int lowBound(int[] nums, int x){
        int left = -1;
        int right = nums.length;
        while(left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if(nums[mid] < x) left = mid;
            else right = mid;
        }
        return right;
    }
}
