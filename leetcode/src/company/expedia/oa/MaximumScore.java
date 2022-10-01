package company.expedia.oa;

import java.util.PriorityQueue;

public class MaximumScore {
    int solution(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            pq.add(i);
            if (pq.size() > k) pq.poll();
        }
        int res = 0;
        while (!pq.isEmpty()) {
            res += pq.poll();
        }
        return res;
    }
}
