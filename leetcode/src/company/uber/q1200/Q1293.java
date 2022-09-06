package company.uber.q1200;

import java.util.LinkedList;
import java.util.Queue;

public class Q1293 {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, k});
        boolean[][][] visited = new boolean[m][n][k + 1];
        visited[0][0][k] = true;
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if (poll[0] == m - 1 && poll[1] == n - 1) return res;
                for (int[] dir : dirs) {
                    int x = poll[0] + dir[0], y = poll[1] + dir[1], remainK = poll[2];
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    if (grid[x][y] == 1) remainK--;
                    if (remainK < 0) continue;
                    if (visited[x][y][remainK]) continue;
                    visited[x][y][remainK] = true;
                    queue.add(new int[]{x, y, remainK});
                }
            }
            res++;
        }
        return -1;
    }
}
