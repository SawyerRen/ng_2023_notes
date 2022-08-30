package company.bloomberg.q600;

import java.util.HashSet;
import java.util.Set;

public class Q694 {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder builder = new StringBuilder();
                    dfs(grid, i, j, builder, m, n, "o");
                    set.add(builder.toString());
                }
            }
        }
        return set.size();
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void dfs(int[][] grid, int i, int j, StringBuilder builder, int m, int n, String d) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 0;
        builder.append(d);
        dfs(grid, i - 1, j, builder, m, n, "l");
        dfs(grid, i, j + 1, builder, m, n, "u");
        dfs(grid, i + 1, j, builder, m, n, "r");
        dfs(grid, i, j - 1, builder, m, n, "d");
        builder.append("b");
    }
}
