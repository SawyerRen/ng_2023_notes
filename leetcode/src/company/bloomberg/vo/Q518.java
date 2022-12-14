package company.bloomberg.vo;

public class Q518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i < amount + 1; i++) {
                if (i >= coin) dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
