package greedy;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int[] candyVec = new int[ratings.length];
        candyVec[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            candyVec[i] = ratings[i] > ratings[i - 1] ? candyVec[i - 1] + 1 : 1;
        }
        for (int i = ratings.length - 2; i >= 0;i--){
            if(ratings[i] > ratings[i+1]) {
                candyVec[i] = Math.max(candyVec[i + 1] + 1, candyVec[i]);
            }
        }
        int sum = 0;
        for (int c : candyVec) {
            sum += c;
        }
        return sum;
    }
}
