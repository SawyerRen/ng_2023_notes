package company.uber.q100;

public class Q188 {
    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length / 2) return helper(prices);
        int n = prices.length;
        int[][][] dp = new int[n][2][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < k + 1; j++) {
                if (i == 0) {
                    dp[i][0][j] = 0;
                    dp[i][1][j] = -prices[0];
                } else {
                    dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j] + prices[i]);
                    dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j - 1] - prices[i]);
                }
            }
        }
        return dp[n - 1][0][k];
    }

    private int helper(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                res += prices[i + 1] - prices[i];
            }
        }
        return res;
    }
}
