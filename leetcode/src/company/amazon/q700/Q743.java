package company.amazon.q700;

import java.util.*;

public class Q743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{k, 0});
        Set<Integer> visited = new HashSet<>();
        int res = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int dist = poll[1], node = poll[0];
            if (visited.contains(node)) continue;
            n--;
            visited.add(node);
            res = dist;
            if (map.containsKey(node)) {
                for (Integer nextNode : map.get(node).keySet()) {
                    int nextDist = dist + map.get(node).get(nextNode);
                    pq.add(new int[]{nextNode, nextDist});
                }
            }
        }
        return n == 0 ? res : -1;
    }
}
