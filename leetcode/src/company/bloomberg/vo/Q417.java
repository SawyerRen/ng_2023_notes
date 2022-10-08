package company.bloomberg.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            helper(heights, canReachP, i, 0, m, n, new boolean[m][n]);
            helper(heights, canReachA, i, n - 1, m, n, new boolean[m][n]);
        }
        for (int j = 0; j < n; j++) {
            helper(heights, canReachP, 0, j, m, n, new boolean[m][n]);
            helper(heights, canReachA, m - 1, j, m, n, new boolean[m][n]);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachA[i][j] && canReachP[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void helper(int[][] heights, boolean[][] canReach, int i, int j, int m, int n, boolean[][] visited) {
        canReach[i][j] = true;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || heights[x][y] < heights[i][j]) continue;
            helper(heights, canReach, x, y, m, n, visited);
        }
    }
}
