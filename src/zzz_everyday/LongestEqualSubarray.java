package zzz_everyday;

import java.util.*;

public class LongestEqualSubarray {
    public static int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        List<Integer>[] posLists = new ArrayList[n + 1];
        Arrays.setAll(posLists, i -> new ArrayList<>());
        for(int i = 0;i < n;i++){
            int x = nums.get(i);
            posLists[x].add(i - posLists[x].size());
        }
        // 1 -> [0, 4] -> [0, 3]
        // 2 -> [2] -> [2]
        // 3 -> [1, 3, 5] -> [1, 2, 3]
        int ans = 0;
        for(List<Integer> pos : posLists){
            if(pos.size() <= ans){
                continue;
            }
            int left = 0;
            for(int right = 0; right < pos.size();right++){
                while(pos.get(right)-pos.get(left) > k){
                    left++;
                }
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(3);
        nums.add(2);
        nums.add(3);
        nums.add(1);
        nums.add(3);
        System.out.println(longestEqualSubarray(nums, 3));
    }
}
