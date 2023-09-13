package greedy;

import java.util.Arrays;

public class FindContentChildren {
    // g是胃口,s是饼干
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0, j = 0; i < s.length && j < g.length; i++) {
            if(s[i] >= g[j]) {
                count++;
                j++;
            }
        }
        return count;
    }
}
