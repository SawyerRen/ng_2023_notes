package company.uber.q700;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q759 {
    private class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> schedule.get(a[0]).get(a[1]).start - schedule.get(b[0]).get(b[1]).start);
        List<Interval> res = new ArrayList<>();
        for (int i = 0; i < schedule.size(); i++) {
            pq.add(new int[]{i, 0});
        }
        int end = schedule.get(pq.peek()[0]).get(pq.peek()[1]).end;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            Interval interval = schedule.get(poll[0]).get(poll[1]);
            int start = interval.start;
            if (start > end) res.add(new Interval(end, start));
            end = Math.max(end, interval.end);
            if (poll[1] + 1 < schedule.get(poll[0]).size()) {
                pq.add(new int[]{poll[0], poll[1] + 1});
            }
        }
        return res;
    }
}
