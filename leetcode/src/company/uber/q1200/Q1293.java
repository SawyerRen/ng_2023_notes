package company.uber.q1200;

import java.util.LinkedList;
import java.util.Queue;

public class Q1293 {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[m][n][k + 1];
        queue.add(new int[]{0, 0, k});
        visited[0][0][k] = true;
        int res = 0;
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if (poll[0] == m - 1 && poll[1] == n - 1) return res;
                for (int[] dir : dirs) {
                    int x = poll[0], y = poll[1], remainK = poll[2];
                    int r = x + dir[0], c = y + dir[1];
                    if (r < 0 || r >= m || c < 0 || c >= n) continue;
                    if (grid[r][c] == 1) remainK--;
                    if (remainK < 0) continue;
                    if (visited[r][c][remainK]) continue;
                    queue.add(new int[]{r, c, remainK});
                    visited[r][c][remainK] = true;
                }
            }
            res++;
        }
        return -1;
    }
}
