package company.bloomberg.vo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (x == y) continue;
            pq.add(x - y);
        }
        if (pq.isEmpty()) return 0;
        return pq.poll();
    }
}
