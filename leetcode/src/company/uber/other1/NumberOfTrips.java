package company.uber.other1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberOfTrips {
    public static void printNumberOfTrips(int[][] trips) {
        int min = trips[0][0], max = trips[0][1];
        for (int[] trip : trips) {
            min = Math.min(min, trip[0]);
            max = Math.max(max, trip[1]);
        }
        int[] nums = new int[max + 1];
        for (int[] trip : trips) {
            nums[trip[0]]++;
            nums[trip[1]]--;
        }
        int count = 0;
        for (int i = min; i <= max; i++) {
            count += nums[i];
            System.out.println(i + ":" + count);
        }
    }

    public static void printNumberOfTrips1(int[][] trips) {
        Arrays.sort(trips, (a, b) -> a[0] - b[0]);
        int start = trips[0][0], end = trips[0][1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int index = 0;
        for (int i = start; i <= end || index < trips.length; i++) {
            while (!pq.isEmpty() && pq.peek() == i) pq.poll();
            while (index < trips.length && i == trips[index][0]) {
                pq.add(trips[index][1]);
                end = Math.max(end, trips[index][1]);
                index++;
            }
            System.out.println(i + ":" + pq.size());
        }
    }


}
