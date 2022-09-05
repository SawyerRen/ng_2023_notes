package company.uber.q800;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] dislike : dislikes) {
            map.putIfAbsent(dislike[0], new HashSet<>());
            map.get(dislike[0]).add(dislike[1]);
            map.putIfAbsent(dislike[1], new HashSet<>());
            map.get(dislike[1]).add(dislike[0]);
        }
        int[] color = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (color[i] == 0 && !dfs(map, color, i, 1)) return false;
        }
        return true;
    }

    private boolean dfs(Map<Integer, Set<Integer>> map, int[] colors, int i, int color) {
        colors[i] = color;
        if (map.containsKey(i)) {
            for (Integer next : map.get(i)) {
                if (colors[next] == color) return false;
                if (colors[next] == 0 && !dfs(map, colors, next, -color)) return false;
            }
        }
        return true;
    }
}
