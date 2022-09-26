package company.uber.all1;

import java.util.LinkedList;
import java.util.Queue;

public class Q994 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) count++;
                else if (grid[i][j] == 2) queue.add(new int[]{i, j});
            }
        }
        if (count == 0) return 0;
        int res = 0;
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] dir : dirs) {
                    int x = poll[0] + dir[0], y = poll[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) continue;
                    count--;
                    if (count == 0) return res;
                    queue.add(new int[]{x, y});
                    grid[x][y] = 2;
                }
            }
        }
        return -1;
    }
}
