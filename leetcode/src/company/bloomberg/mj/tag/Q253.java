package company.bloomberg.mj.tag;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q253 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        for (int[] interval : intervals) {
            while (!pq.isEmpty() && pq.peek() <= interval[0]) {
                pq.poll();
            }
            pq.add(interval[1]);
            res = Math.max(res, pq.size());
        }
        return res;
    }
}
