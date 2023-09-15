package zzz_everyday;

import java.util.Arrays;

public class GiveGem {
    public static int giveGem(int[] gem, int[][] operations) {
        for(int j = 0;j < operations.length;j++) {
            int[] give = operations[j];
            int g = gem[give[0]] / 2;
            gem[give[0]] -= g;
            gem[give[1]] += g;
        }
        Arrays.sort(gem);
        return gem[gem.length-1] - gem[0];
    }

    public static void main(String[] args){
        int[] gem = {3,1,2};
        int[][] operations = {{0,2},{2,1},{2,0}};
        System.out.println(giveGem(gem, operations));
    }
}
