package company.bytedance.oa;

/**
 * n*m矩阵里种一些树，把这个矩形切成k份分给k个人，
 * 每一刀要横着或者竖着切到底，横着切的话左边给一个人，剩下继续切；
 * 竖着切上面给一个人，剩下的继续。要保证每个人的区域都有树。
 * 求方案数%1e9+7
 */
public class Q2 {
    int solution(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        Integer[][][] dp = new Integer[k][m][n];
        int[][] preSum = new int[m + 1][n + 1]; // preSum[r][c] is the total number of apples in pizza[r:][c:]
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                preSum[r][c] = preSum[r][c + 1] + preSum[r + 1][c] - preSum[r + 1][c + 1] + (matrix[r][c] == 1 ? 1 : 0);

            }
        }
        return helper(m, n, k - 1, 0, 0, dp, preSum);
    }

    int helper(int m, int n, int k, int r, int c, Integer[][][] dp, int[][] preSum) {
        if (preSum[r][c] < k) return 0;
        if (preSum[r][c] == 0) return 0; // if the remain piece has no apple -> invalid
        if (k == 0) return 1; // found valid way after using k-1 cuts
        if (dp[k][r][c] != null) return dp[k][r][c];
        int ans = 0;
        // cut in horizontal
        for (int nr = r + 1; nr < m; nr++)
            if (preSum[r][c] - preSum[nr][c] > 0) // cut if the upper piece contains at least one apple
                ans = (ans + helper(m, n, k - 1, nr, c, dp, preSum)) % 1_000_000_007;
        // cut in vertical
        for (int nc = c + 1; nc < n; nc++)
            if (preSum[r][c] - preSum[r][nc] > 0) // cut if the left piece contains at least one apple
                ans = (ans + helper(m, n, k - 1, r, nc, dp, preSum)) % 1_000_000_007;
        return dp[k][r][c] = ans;
    }

    final int MOD = (int) 1e9 + 7;
    int m, n, k;
    int[][] sums;
    Integer[][][] dp;

    public int ways(String[] pizza, int k) {
        this.k = k;
        m = pizza.length;
        n = pizza[0].length();
        sums = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--)
                sums[i][j] = (pizza[i].charAt(j) == 'A' ? 1 : 0)
                        + sums[i + 1][j] + sums[i][j + 1] - sums[i + 1][j + 1];
        dp = new Integer[m][n][k + 1];
        return wayRec(0, 0, 1);
    }

    private int wayRec(int i, int j, int v) {
        if (dp[i][j][v] != null) return dp[i][j][v];
        if (v == k) return dp[i][j][v] = (sums[i][j] > 0 ? 1 : 0);
        int ret = 0;
        for (int r = i; r < m - 1; r++)
            if (sums[i][j] - sums[r + 1][j] > 0) ret = (ret + wayRec(r + 1, j, v + 1)) % MOD;
        for (int c = j; c < n - 1; c++)
            if (sums[i][j] - sums[i][c + 1] > 0) ret = (ret + wayRec(i, c + 1, v + 1)) % MOD;
        return dp[i][j][v] = ret;
    }
}
