package company.bloomberg.q1000;

import java.util.PriorityQueue;

public class Q1029 {
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int diff1 = costs[a][0] - costs[a][1];
            int diff2 = costs[b][0] - costs[b][1];
            return diff1 - diff2;
        });
        for (int i = 0; i < costs.length; i++) {
            pq.add(i);
        }
        int res = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            Integer index = pq.poll();
            res += costs[index][0];
        }
        for (int i = 0; i < costs.length / 2; i++) {
            Integer index = pq.poll();
            res += costs[index][1];
        }
        return res;
    }
}
