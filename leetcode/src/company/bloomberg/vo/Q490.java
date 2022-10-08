package company.bloomberg.vo;

import java.util.LinkedList;
import java.util.Queue;

public class Q490 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if (poll[0] == destination[0] && poll[1] == destination[1]) return true;
                for (int[] dir : dirs) {
                    int x = poll[0] + dir[0], y = poll[1] + dir[1];
                    while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                        x += dir[0];
                        y += dir[1];
                    }
                    x -= dir[0];
                    y -= dir[1];
                    if (visited[x][y]) continue;
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }
}
