package company.bloomberg.vo;

import java.util.Arrays;

public class Q935 {
    int[][] arr = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};

    public int knightDialer(int n) {
        int[] dp = new int[10];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            int[] temp = new int[10];
            for (int num = 0; num < 10; num++) {
                for (int nextNum : arr[num]) {
                    temp[nextNum] = (temp[nextNum] + dp[num]) % 1000000007;
                }
            }
            dp = temp;
        }
        int res = 0;
        for (int i : dp) {
            res = (res + i) % 1000000007;
        }
        return res;
    }

    public int knightDialer1(int n) {
        int res = 0;
        int[][] memo = new int[10][n + 1];
        for (int i = 0; i < 10; i++) {
            res = (res + helper(memo, i, n)) % 1000000007;
        }
        return res;
    }

    private int helper(int[][] memo, int i, int n) {
        if (n == 1) return 1;
        if (memo[i][n] != 0) return memo[i][n];
        int res = 0;
        for (int next : arr[i]) {
            res = (res + helper(memo, next, n - 1)) % 1000000007;
        }
        memo[i][n] = res;
        return res;
    }
}
