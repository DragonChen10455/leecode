package zzz_everyday;

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int n = s.length();
        if(n < 1) return 0;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if(s.charAt(i-1) == '(') {
                    dp[i] = (i-2 >= 0) ? dp[i-2]+2 : 2;
                } else if(i - dp[i-1] > 0 && s.charAt(i - dp[i-1] - 1) == '(') {
                    dp[i] = dp[i-1] + dp[i - dp[i-1] - 2] + 2;
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "()(())";
        System.out.println(longestValidParentheses(s));
    }
}
