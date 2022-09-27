package company.uber.all2;

import javafx.util.Pair;

import java.util.*;

public class Q864 {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        Queue<Pair<int[], int[]>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int[] target = new int[26];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    queue.add(new Pair<>(new int[]{i, j}, new int[26]));
                    visited.add(i + ":" + j + ":" + Arrays.toString(new int[26]));
                }
                if (c >= 'a' && c <= 'z') {
                    target[c - 'a'] = 1;
                }
            }
        }
        String targetStr = Arrays.toString(target);
        int res = 0;
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<int[], int[]> poll = queue.poll();
                int row = poll.getKey()[0], col = poll.getKey()[1];
                int[] keys = poll.getValue();
                if (Arrays.toString(keys).equals(targetStr)) return res;
                for (int[] dir : dirs) {
                    int x = row + dir[0], y = col + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x].charAt(y) == '#') continue;
                    char c = grid[x].charAt(y);
                    if (c <= 'Z' && c >= 'A' && keys[c - 'A'] == 0) continue;
                    if (c <= 'z' && c >= 'a') keys[c - 'a'] = 1;
                    String s = x + ":" + y + ":" + Arrays.toString(keys);
                    if (visited.contains(s)) continue;
                    queue.add(new Pair<>(new int[]{x, y}, keys));
                    visited.add(s);
                }
            }
            res++;
        }
        return -1;
    }
}
