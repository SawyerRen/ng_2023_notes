package company.bloomberg.q200;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q253 {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int res = 0;
        for (int[] interval : intervals) {
            while (!pq.isEmpty() && interval[0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(interval[1]);
            res = Math.max(res, pq.size());
        }
        return res;
    }
}
