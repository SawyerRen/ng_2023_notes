package company.uber.lastround;

import javax.swing.table.TableRowSorter;
import java.util.LinkedList;
import java.util.Queue;

public class Q1293 {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        boolean[][][] visited = new boolean[m][n][k + 1];
        Queue<int[]> queue = new LinkedList<>();
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
                    int x = poll[0] + dir[0], y = poll[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    int remainK = poll[2];
                    if (grid[x][y] == 1) remainK--;
                    if (remainK < 0) continue;
                    if (visited[x][y][remainK]) continue;
                    queue.add(new int[]{x, y, remainK});
                    visited[x][y][remainK] = true;
                }
            }
            res++;
        }
        return -1;
    }
}
