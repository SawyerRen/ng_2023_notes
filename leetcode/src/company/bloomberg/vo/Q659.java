package company.bloomberg.vo;

import java.util.PriorityQueue;

public class Q659 {
    class Interval {
        int start;
        int end;
        int length;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
            this.length = end - start + 1;
        }
    }

    public boolean isPossible(int[] nums) {
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.end == b.end ? a.length - b.length : a.end - b.end);
        for (int num : nums) {
            while (!pq.isEmpty() && num > pq.peek().end + 1) {
                Interval poll = pq.poll();
                if (poll.length < 3) return false;
            }
            if (pq.isEmpty() || num == pq.peek().end) {
                pq.add(new Interval(num, num));
            } else {
                Interval poll = pq.poll();
                pq.add(new Interval(poll.start, num));
            }
        }
        while (!pq.isEmpty()) {
            if (pq.poll().length < 3) return false;
        }
        return true;
    }
}
