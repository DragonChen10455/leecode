package zzz_everyday;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (prices.length == 0) return 0;
        // 0: 没有状态
        // 1: 第一次持有股票
        // 2: 第一次不持有股票
        // 3: 第二次持有股票
        // 4: 第二次不持有股票
        int[][] dp = new int[len][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for(int i = 1;i < len;i++) {
            dp[i][0] = dp[i-1][0];
            dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);
            dp[i][2] = Math.max(dp[i-1][1] + prices[i], dp[i-1][2]);
            dp[i][3] = Math.max(dp[i-1][2] - prices[i], dp[i-1][3]);
            dp[i][4] = Math.max(dp[i-1][3] + prices[i], dp[i-1][4]);
        }
        return dp[len - 1][4];
    }
}
