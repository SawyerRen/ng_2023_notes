package company.uber.other;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberOfTrips {
    public static void printNumberOfTrips(int[][] trips) {
        int start = trips[0][0], end = trips[0][1];
        for (int[] trip : trips) {
            start = Math.min(start, trip[0]);
            end = Math.max(end, trip[1]);
        }
        int[] count = new int[end + 1];
        for (int[] trip : trips) {
            count[trip[0]]++;
            count[trip[1]]--;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            num += count[i];
            System.out.println(i + ":" + num);
        }
    }

    public static void printNumberOfTrips1(int[][] trips) {
        Arrays.sort(trips, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int start = trips[0][0], end = trips[0][1];
        int index = 0;
        for (int i = start; i <= end; i++) {
            while (!pq.isEmpty() && pq.peek() == i) {
                pq.poll();
            }
            while (index < trips.length && trips[index][0] == i) {
                pq.add(trips[index][1]);
                end = Math.max(end, trips[index][1]);
                index++;
            }
            System.out.println(i + ":" + pq.size());
        }
    }

    public static void main(String[] args) {
        int[][] trips = {{100, 105}, {103, 107}, {101, 102}, {103, 106}};
        printNumberOfTrips(trips);
    }
}
