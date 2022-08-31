package company.bloomberg.q900;

import java.util.Arrays;

public class Q935 {
    int[][] next = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
    int mod = 1000000007;

    public int knightDialer(int n) {
        int[][] dp = new int[n][10];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int num : next[j]) {
                    dp[i][num] = (dp[i][num] + dp[i - 1][j]) % mod;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + dp[n - 1][i]) % mod;
        }
        return res;
    }

    public int knightDialer1(int n) {
        int[][] memo = new int[n + 1][10];
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + helper(memo, n, i)) % mod;
        }
        return res;
    }

    private int helper(int[][] memo, int n, int i) {
        if (n == 1) return 1;
        if (memo[n][i] != 0) return memo[n][i];
        int res = 0;
        for (int num : next[i]) {
            res = (res + helper(memo, n - 1, num)) % mod;
        }
        memo[n][i] = res;
        return res;
    }
}
