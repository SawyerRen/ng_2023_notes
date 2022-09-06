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
            map.putIfAbsent(dislike[1], new HashSet<>());
            map.get(dislike[0]).add(dislike[1]);
            map.get(dislike[1]).add(dislike[0]);
        }
        int[] colors = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            if (colors[i] == 0 && !helper(map, i, colors, 1)) return false;
        }
        return true;
    }

    private boolean helper(Map<Integer, Set<Integer>> map, int i, int[] colors, int color) {
        if (colors[i] != 0) return colors[i] == color;
        colors[i] = color;
        if (map.containsKey(i)) {
            for (Integer next : map.get(i)) {
                if (!helper(map, next, colors, -color)) return false;
            }
        }
        return true;
    }
}
