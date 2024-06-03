package zzz_everyday;

import java.util.*;

public class MaximumLength {
    public int maximumLength(String s) {
        List<Integer>[] groups = new ArrayList[26];
        Arrays.setAll(groups, i -> new ArrayList<>());
        int cnt = 0;
        for(int i = 0;i < s.length();i++){
            cnt++;
            if(i + 1 == s.length() || s.charAt(i) != s.charAt(i+1)){
                groups[s.charAt(i) - 'a'].add(cnt);
                cnt = 0;
            }
        }

        int ans = 0;
        for(List<Integer> list : groups){
            if(list.size() == 0) continue;
            list.sort(Collections.reverseOrder());
            list.add(0);
            list.add(0);
            ans = Math.max(ans, Math.max(Math.max(list.get(0)-2, Math.min(list.get(0)-1, list.get(1))), list.get(2)));
        }
        return ans > 0 ? ans : -1;
    }
}
