package dp;

public class MaxProfit {
    public int maxProfit1(int[] prices) {
        int low = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < prices.length; i++){
            low = Math.min(prices[i], low);
            res = Math.max(prices[i] - low, res);
        }
        return res;
    }

    public int maxProfit2(int[] prices) {
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

    public int maxProfit3(int[] prices) {
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

    public int maxProfit4(int k, int[] prices) {
        if(prices.length == 0) return 0;
        int len = prices.length;
        int[][] dp = new int[len][2*k+1];

        for(int i = 1;i < k*2;i+=2) {
            dp[0][i] = -prices[0];
        }

        for(int i = 1;i < len;i++) {
            for(int j = 0;j < 2*k-1;j+=2) {
                dp[i][j+1] = Math.max(dp[i-1][j+1], dp[i-1][j]-prices[i]);
                dp[i][j+2] = Math.max(dp[i-1][j+2], dp[i-1][j+1]+prices[i]);
            }
        }

        return dp[len-1][2*k];
    }

    public int maxProfitWithFreeze(int[] prices) {
        int n = prices.length;
        if(n <= 1) return 0;
        int[][] dp = new int[n][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for(int i = 1;i < n;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            dp[i][2] = dp[i-1][1] + prices[i];
        }
        return Math.max(dp[n-1][0],dp[n-1][2]);
    }

    public int maxProfitWithFee(int[] prices, int fee) {
        int n = prices.length;
        if(n <= 1) return 0;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];
        for(int i = 1;i < prices.length;i++) {
            int tmp = dp[0];
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            dp[1] = Math.max(dp[1], tmp - prices[i]);
        }
        return Math.max(dp[0],dp[1]);
    }
}
