package company.uber.all1;

import java.util.*;

public class Q310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return new ArrayList<>(Collections.singletonList(0));
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> preCount = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new HashSet<>());
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
            preCount.put(edge[0], preCount.getOrDefault(edge[0], 0) + 1);
            preCount.put(edge[1], preCount.getOrDefault(edge[1], 0) + 1);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Integer e : preCount.keySet()) {
            if (preCount.get(e) == 1) queue.add(e);
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res = new ArrayList<>(queue);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer e1 = queue.poll();
                if (map.containsKey(e1)) {
                    for (Integer e2 : map.get(e1)) {
                        preCount.put(e2, preCount.get(e2) - 1);
                        if (preCount.get(e2) == 1) {
                            queue.add(e2);
                        }
                    }
                }
            }
        }
        return res;
    }
}
