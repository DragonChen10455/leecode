package zzz_everyday;

import java.util.*;

public class AvoidFlood {
    public static int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Arrays.fill(ans, 1);
        // 晴天
        TreeSet<Integer> set = new TreeSet<Integer>();
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for(int i = 0;i < rains.length;i++) {
            // 记录晴天
            if(rains[i] == 0) {
                set.add(i);
            } else {
                ans[i] = -1;
                if(mp.containsKey(rains[i])) {
                    Integer it = set.ceiling(mp.get(rains[i]));
                    if(it == null) {
                        return new int[0];
                    }
                    ans[it] = rains[i];
                    set.remove(it);
                }
                mp.put(rains[i], i);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] rains = {1,2,0,0,2,1};
        System.out.println(Arrays.toString(avoidFlood(rains)));
    }
}
