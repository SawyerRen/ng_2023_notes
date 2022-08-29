package company.uber.q800;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q864 {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        int targetKey = 0;
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    queue.add(new int[]{0, i, j});
                    visited.add(0 + "_" + i + "_" + j);
                } else if (c >= 'a' && c <= 'f') {
                    targetKey |= (1 << (c - 'a'));
                }
            }
        }
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] dir : dirs) {
                    int key = poll[0], x = poll[1] + dir[0], y = poll[2] + dir[1];
                    if (key == targetKey) return res;
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    char c = grid[x].charAt(y);
                    if (c == '#') continue;
                    if (c >= 'A' && c <= 'F' && ((key >> (c - 'A')) & 1) == 0) continue;
                    if (c >= 'a' && c <= 'f') key |= 1 << (c - 'a');
                    if (visited.contains(key + "_" + x + "_" + y)) continue;
                    queue.add(new int[]{key, x, y});
                    visited.add(key + "_" + x + "_" + y);
                }
            }
        }
        return -1;
    }
}
