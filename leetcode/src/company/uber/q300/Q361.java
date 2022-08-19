package company.uber.q300;

public class Q361 {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] count = new int[m][n];
        int num = 0;
        int res = 0;
        for (int row = 0; row < m; row++) {
            num = 0;
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 'W') num = 0;
                else if (grid[row][col] == 'E') num++;
                else count[row][col] += num;
            }
            num = 0;
            for (int col = n - 1; col >= 0; col--) {
                if (grid[row][col] == 'W') num = 0;
                else if (grid[row][col] == 'E') num++;
                else count[row][col] += num;
            }
        }
        for (int col = 0; col < n; col++) {
            num = 0;
            for (int row = 0; row < m; row++) {
                if (grid[row][col] == 'W') num = 0;
                else if (grid[row][col] == 'E') num++;
                else count[row][col] += num;
            }
            num = 0;
            for (int row = m - 1; row >= 0; row--) {
                if (grid[row][col] == 'W') num = 0;
                else if (grid[row][col] == 'E') num++;
                else {
                    count[row][col] += num;
                    res = Math.max(res, count[row][col]);
                }
            }
        }
        return res;
    }
}
