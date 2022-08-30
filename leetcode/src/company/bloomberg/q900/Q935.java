package company.bloomberg.q900;

public class Q935 {
    String[] nextList = {"46", "68", "79", "48", "039", "", "170", "26", "13", "24"};
    int mod = 1000000007;

    public int knightDialer(int n) {
        int[][] memo = new int[n + 1][10];
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + helper(memo, i, n)) % mod;
        }
        return res;
    }

    private int helper(int[][] memo, int i, int n) {
        if (n == 1) return 1;
        if (memo[n][i] != 0) return memo[n][i];
        int res = 0;
        for (char c : nextList[i].toCharArray()) {
            res = (res + helper(memo, c - '0', n - 1)) % mod;
        }
        memo[n][i] = res;
        return res;
    }
}
