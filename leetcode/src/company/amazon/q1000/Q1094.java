package company.amazon.q1000;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] count = new int[1001];
        for (int[] trip : trips) {
            count[trip[1]] += trip[0];
            count[trip[2]] -= trip[0];
        }
        int used = 0;
        for (int i : count) {
            used += i;
            if (used > capacity) return false;
        }
        return true;
    }

    public boolean carPooling1(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        int count = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int[] trip : trips) {
            while (!pq.isEmpty() && pq.peek()[2] <= trip[1]) {
                count -= pq.poll()[0];
            }
            count += trip[0];
            if (count > capacity) return false;
            pq.add(trip);
        }
        return true;
    }
}
