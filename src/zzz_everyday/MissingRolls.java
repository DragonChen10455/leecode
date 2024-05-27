package zzz_everyday;

import java.util.Arrays;

public class MissingRolls {
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int curSum = 0;
        for(int i = 0;i < m;i++){
            curSum += rolls[i];
        }
        int leftSum = mean * (n + m) - curSum;
        if(leftSum < n || leftSum > 6 * n) return new int[0];
        int[] res = new int[n];
        int leftMean = leftSum / n;
        int leftMod = leftSum % n;
        for(int i = 0;i < n;i++){
            if(leftMod > 0) {
                res[i] = leftMean + 1;
                leftMod--;
            } else {
                res[i] = leftMean;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] rolls = {6,1,5,2};
        int[] res = missingRolls(rolls, 4, 4);
        System.out.println(Arrays.toString(res));
    }
}
