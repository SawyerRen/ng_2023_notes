package company.amazon.q600;

public class Q695 {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j, m, n));
                }
            }
        }
        return res;
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private int dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return 0;
        int res = 1;
        grid[i][j] = 0;
        for (int[] dir : dirs) {
            res += dfs(grid, i + dir[0], j + dir[1], m, n);
        }
        return res;
    }
}
