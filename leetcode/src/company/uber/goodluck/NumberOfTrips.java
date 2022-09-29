package company.uber.goodluck;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfTrips {
    void solution(int[][] trips) {
        Arrays.sort(trips, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int start = trips[0][0], end = trips[0][1];
        int index = 0;
        for (int i = start; i < end + 1 || index < trips.length; i++) {
            while (!pq.isEmpty() && pq.peek() == i) {
                pq.poll();
            }
            while (index < trips.length && i == trips[index][0]) {
                pq.add(trips[index][1]);
                end = Math.max(end, trips[index][1]);
                index++;
            }
            System.out.println(i + ":" + pq.size());
        }
    }
}
