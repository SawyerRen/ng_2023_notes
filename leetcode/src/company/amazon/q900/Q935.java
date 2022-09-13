package company.amazon.q900;

public class Q935 {
    int[][] next = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
    int mod = 1000000007;

    public int knightDialer(int n) {
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
        for (int next : next[i]) {
            res = (res + helper(memo, n - 1, next)) % mod;
        }
        memo[n][i] = res;
        return res;
    }
}
