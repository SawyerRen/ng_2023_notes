package company.uber.q300;

import java.util.*;

public class Q310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new HashSet<>());
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (Integer edge : map.keySet()) {
            if (map.get(edge).size() == 1) {
                queue.add(edge);
                res.add(edge);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            res = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                res.add(poll);
                if (map.containsKey(poll)) {
                    for (Integer next : map.get(poll)) {
                        map.get(next).remove(poll);
                        if (map.get(next).size() == 1) {
                            queue.add(next);
                        }
                    }
                }
            }
        }
        return res;
    }
}
