package company.amazon.finalround;

import java.util.*;

public class Q787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] flight : flights) {
            map.putIfAbsent(flight[0], new HashMap<>());
            map.get(flight[0]).put(flight[1], flight[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{src, k + 1, 0});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int city = poll[0], remainK = poll[1], cost = poll[2];
            if (city == dst) return cost;
            if (remainK == 0) continue;
            if (map.containsKey(city)) {
                for (Integer nextCity : map.get(city).keySet()) {
                    pq.add(new int[]{nextCity, remainK - 1, cost + map.get(city).get(nextCity)});
                }
            }
        }
        return -1;
    }
}
