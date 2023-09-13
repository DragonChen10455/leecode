package greedy;

import java.util.Arrays;

public class MaxProfit {
    public static int maxProfit(int[] prices) {
        for (int i = 0; i < prices.length - 1; i++) {
            prices[i] = prices[i+1] - prices[i];
        }
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] > 0) {
                res += prices[i];
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
