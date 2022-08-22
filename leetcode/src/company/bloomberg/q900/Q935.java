package company.bloomberg.q900;

public class Q935 {
    String[] nextList = {"46", "68", "79", "48", "039", "", "170", "26", "13", "24"};
    int mod = 1000000007;

    public int knightDialer(int n) {
        int[][] memo = new int[10][n + 1];
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + helper(memo, i, n)) % mod;
        }
        return res;
    }

    private int helper(int[][] memo, int num, int n) {
        if (n == 1) return 1;
        if (memo[num][n] != 0) return memo[num][n];
        int res = 0;
        for (char c : nextList[num].toCharArray()) {
            int next = c - '0';
            res = (res + helper(memo, next, n - 1)) % mod;
        }
        memo[num][n] = res;
        return res;
    }
}
