package zzz_everyday;

import java.util.*;

public class FindMaximumElegance {
    public long findMaximumElegance(int[][] items, int k) {
        Arrays.sort(items, (item0, item1) -> item1[0] - item0[0]);
        long total = 0L, res = 0L;
        Set<Integer> c = new HashSet<>();
        Deque<Integer> s = new ArrayDeque<>();
        for(int i = 0;i < items.length;i++){
            if(i < k){
                total += items[i][0];
                if(!c.add(items[i][1])) {
                    s.push(items[i][0]);
                }
            } else if (!s.isEmpty() && c.add(items[i][1])){
                total -= s.pop();
                total += items[i][0];
            }
            long totalC = c.size();
            res = Math.max(res, total + totalC * totalC);
        }
        return res;
    }
}
