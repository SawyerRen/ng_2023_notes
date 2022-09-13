package company.amazon.q200;

import java.util.LinkedList;
import java.util.Queue;

public class Q286 {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) queue.add(new int[]{i, j});
            }
        }
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            dist++;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] dir : dirs) {
                    int x = poll[0] + dir[0], y = poll[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || rooms[x][y] != Integer.MAX_VALUE) continue;
                    rooms[x][y] = dist;
                    queue.add(new int[]{x, y});
                }
            }
        }
    }
}
