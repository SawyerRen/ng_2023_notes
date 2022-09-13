package company.amazon.q1100;

import java.util.PriorityQueue;

public class Q1167 {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stick : sticks) {
            pq.add(stick);
        }
        int res = 0;
        while (pq.size() > 1) {
            int n1 = pq.poll();
            int n2 = pq.poll();
            res += n1 + n2;
            pq.add(n1 + n2);
        }
        return res;
    }
}
