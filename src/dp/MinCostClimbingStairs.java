package dp;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        // 到第0阶楼梯不需要往上走
        dp[0] = 0;
        // 到第1阶楼梯不需要往上走
        dp[1] = 0;
        for(int i = 2;i < n+1;i++) {
            dp[i] = Math.min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1]);
        }
        return dp[n];
    }
}
