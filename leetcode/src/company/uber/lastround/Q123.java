package company.uber.lastround;

public class Q123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for (int i = 0; i < n; i++) {
            for (int k = 1; k < 3; k++) {
                if (i == 0) {
                    dp[i][0][k] = 0;
                    dp[i][1][k] = -prices[0];
                } else {
                    dp[i][0][k] = Math.max(dp[i - 1][0][k], dp[i - 1][1][k] + prices[i]);
                    dp[i][1][k] = Math.max(dp[i - 1][1][k], dp[i - 1][0][k - 1] - prices[i]);
                }
            }
        }
        return dp[n - 1][0][2];
    }
}
