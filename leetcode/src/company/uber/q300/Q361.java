package company.uber.q300;

public class Q361 {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    count = 0;
                } else if (grid[i][j] == 'E') {
                    count++;
                } else {
                    dp[i][j] += count;
                }
            }
            count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 'W') {
                    count = 0;
                } else if (grid[i][j] == 'E') {
                    count++;
                } else {
                    dp[i][j] += count;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 'W') {
                    count = 0;
                } else if (grid[i][j] == 'E') {
                    count++;
                } else {
                    dp[i][j] += count;
                }
            }
            count = 0;
            for (int i = m - 1; i >= 0; i--) {
                if (grid[i][j] == 'W') {
                    count = 0;
                } else if (grid[i][j] == 'E') {
                    count++;
                } else {
                    dp[i][j] += count;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
