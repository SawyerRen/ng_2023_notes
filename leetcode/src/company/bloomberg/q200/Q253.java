package company.bloomberg.q200;

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

    int getMeetingRoomAtT(int[][] intervals, int time) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int start = intervals[0][0];
        int index = 0;
        for (int i = start; i <= time; i++) {
            while (!pq.isEmpty() && i >= pq.peek()) {
                pq.poll();
            }
            while (index < intervals.length && i == intervals[i][0]) {
                pq.add(intervals[index++][1]);
            }
        }
        return pq.size();
    }
}
