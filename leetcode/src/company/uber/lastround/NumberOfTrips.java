package company.uber.lastround;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberOfTrips {
    public void solution(int[][] trips) {
        Arrays.sort(trips, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int start = trips[0][0], end = trips[0][1];
        int index = 0;
        for (int i = start; i <= end || index < trips.length; i++) {
            while (!pq.isEmpty() && pq.peek() == i) pq.poll();
            while (index < trips.length && trips[index][0] == i) {
                pq.add(trips[index++][1]);
            }
            System.out.println(i + ":" + pq.size());
        }
    }
}
