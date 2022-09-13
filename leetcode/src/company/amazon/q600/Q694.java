package company.amazon.q600;

import java.util.HashSet;
import java.util.Set;

public class Q694 {
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder builder = new StringBuilder();
                    dfs(grid, i, j, m, n, builder, 'o');
                    set.add(builder.toString());
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int i, int j, int m, int n, StringBuilder builder, char d) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return;
        builder.append(d);
        grid[i][j] = 0;
        dfs(grid, i - 1, j, m, n, builder, 'u');
        dfs(grid, i + 1, j, m, n, builder, 'd');
        dfs(grid, i, j - 1, m, n, builder, 'l');
        dfs(grid, i, j + 1, m, n, builder, 'r');
        builder.append('b');
    }
}
