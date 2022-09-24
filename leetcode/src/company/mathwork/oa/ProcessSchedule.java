package company.mathwork.oa;

import java.util.PriorityQueue;

public class ProcessSchedule {
    int solution(int[] a, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(a[i]);
        }
        int res = 0;
        while (!pq.isEmpty() && k > 0) {
            Integer poll = pq.poll();
            res++;
            k -= poll;
            poll /= 2;
            pq.add(poll);
        }
        return res;
    }
}
