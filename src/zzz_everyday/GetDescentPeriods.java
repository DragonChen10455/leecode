package zzz_everyday;

public class GetDescentPeriods {
    public long getDescentPeriods(int[] prices) {
        long result = 0;
        int count = 0;
        int last = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] != last - 1) {
                count = 0;
            }
            count++;
            result += count;
            last = prices[i];
        }
        return result;
    }
}
