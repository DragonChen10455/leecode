package zzz_everyday;

import java.util.Arrays;

public class MaxArea {
    public static int MOD = (int)1e9+7;
    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int max = Integer.MIN_VALUE;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int n = horizontalCuts.length, m = verticalCuts.length;
        int mh = Math.max(horizontalCuts[0], h - horizontalCuts[n - 1]);
        int mv = Math.max(verticalCuts[0], w - verticalCuts[m - 1]);
        for (int i = 1; i < n; i++)
            mh = Math.max(mh, horizontalCuts[i] - horizontalCuts[i - 1]);
        for (int i = 1; i < m; i++)
            mv = Math.max(mv, verticalCuts[i] - verticalCuts[i - 1]);
        return (int)(((long) mh * mv) % MOD);
    }

    public static void main(String[] args) {
        int[] h = {2};
        int[] w = {2};
        System.out.println(maxArea(1000000000, 1000000000, h, w));
    }
}
