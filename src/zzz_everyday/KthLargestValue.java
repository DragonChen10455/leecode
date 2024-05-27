package zzz_everyday;

import java.util.*;

public class KthLargestValue {
    public static int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j - 1] ^ dp[i - 1][j] ^ dp[i][j - 1] ^ matrix[i-1][j-1];
                res.add(dp[i][j]);
            }
        }
        Collections.sort(res);
        Collections.reverse(res);
        return res.get(k - 1);
    }

    public static void main(String[] args) {
        int[][] matrix = {{9}};
        System.out.println(kthLargestValue(matrix, 1));
    }
}
