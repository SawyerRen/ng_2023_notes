package company.uber.q900;

import java.util.LinkedList;
import java.util.Queue;

public class Q934 {
    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        boolean found = false;
        for (int i = 0; i < m; i++) {
            if (found) break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(queue, visited, grid, i, j, m, n);
                    found = true;
                    break;
                }
            }
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] dir : dirs) {
                    int x = poll[0] + dir[0], y = poll[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                    if (grid[x][y] == 1) return res;
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            res++;
        }
        return -1;
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void dfs(Queue<int[]> queue, boolean[][] visited, int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] != 1) return;
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        for (int[] dir : dirs) {
            dfs(queue, visited, grid, i + dir[0], j + dir[1], m, n);
        }
    }
}
