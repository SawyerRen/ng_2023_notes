package company.bloomberg.q300;

import java.util.Arrays;

public class Q322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] memo = new int[amount];
        return helper(coins, amount, memo);
    }

    private int helper(int[] coins, int amount, int[] memo) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (memo[amount - 1] != 0) return memo[amount - 1];
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = helper(coins, amount - coin, memo);
            if (count >= 0) res = Math.min(res, count + 1);
        }
        memo[amount - 1] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount - 1];
    }

    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
