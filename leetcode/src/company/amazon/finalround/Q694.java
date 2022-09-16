package company.amazon.finalround;

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
                    dfs(builder, grid, i, j, m, n, 'o');
                    set.add(builder.toString());
                }
            }
        }
        return set.size();
    }

    private void dfs(StringBuilder builder, int[][] grid, int i, int j, int m, int n, char d) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return;
        grid[i][j] = 0;
        builder.append(d);
        dfs(builder, grid, i - 1, j, m, n, 'u');
        dfs(builder, grid, i + 1, j, m, n, 'd');
        dfs(builder, grid, i, j + 1, m, n, 'r');
        dfs(builder, grid, i, j - 1, m, n, 'l');
        builder.append('b');
    }
}
