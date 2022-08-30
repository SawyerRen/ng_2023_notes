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

    int[][] nextNumList = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};

    public int knightDialer1(int n) {
        int[] cur = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        for (int i = 1; i < n; i++) {
            int[] temp = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            for (int num = 0; num < 10; num++) {
                for (int next : nextNumList[num]) {
                    temp[next] = (temp[next] + cur[num]) % mod;
                }
            }
            cur = temp;
        }
        int res = 0;
        for (int i : cur) {
            res = (res + i) % mod;
        }
        return res;
    }
}
