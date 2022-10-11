package company.bloomberg.goodluck;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Q1245 {
    int res = 0;

    public int treeDiameter(int[][] edges) {
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new HashSet<>());
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        helper(map, 0, -1);
        return res;
    }

    private int helper(Map<Integer, HashSet<Integer>> map, int cur, int parent) {
        if (!map.containsKey(cur)) return 0;
        int m1 = 0, m2 = 0;
        for (Integer next : map.get(cur)) {
            if (next == parent) continue;
            int d = helper(map, next, cur);
            if (d > m1) {
                m2 = m1;
                m1 = d;
            } else if (d > m2) {
                m2 = d;
            }
        }
        res = Math.max(res, m1 + m2);
        return m1 + 1;
    }
}
