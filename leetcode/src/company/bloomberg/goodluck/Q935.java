package company.bloomberg.goodluck;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Q935 {
    int mod = 1000000007;
    int[][] arr = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}, {4, 6}};

    public int knightDialer(int n) {
        int[] dp = new int[10];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n - 1; i++) {
            int[] temp = new int[10];
            for (int cur = 0; cur < 10; cur++) {
                for (int next : arr[cur]) {
                    temp[next] = (temp[next] + dp[cur]) % mod;
                }
            }
            dp = temp;
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + dp[i]) % mod;
        }
        return res;
    }

    public int knightDialer2(int n) {
        int[][] dp = new int[n][10];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < n - 1; i++) {
            for (int cur = 0; cur < 10; cur++) {
                for (int next : arr[cur]) {
                    dp[i + 1][next] = (dp[i + 1][next] + dp[i][cur]) % mod;
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
        int[][] memo = new int[10][n + 1];
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + helper(memo, i, n)) % mod;
        }
        return res;
    }

    private int helper(int[][] memo, int i, int n) {
        if (n == 1) return 1;
        if (memo[i][n] != 0) return memo[i][n];
        int res = 0;
        for (int next : arr[i]) {
            res = (res + helper(memo, next, n - 1)) % mod;
        }
        memo[i][n] = res;
        return res;
    }
}
