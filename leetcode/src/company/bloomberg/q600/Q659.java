package company.bloomberg.q600;

import java.util.PriorityQueue;

public class Q659 {
    class Interval {
        int start;
        int end;
        int length;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
            length = end - start + 1;
        }
    }

    public boolean isPossible(int[] nums) {
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> {
            if (a.end == b.end) return a.length - b.length;
            return a.end - b.end;
        });
        for (int num : nums) {
            while (!pq.isEmpty() && num > pq.peek().end + 1) {
                Interval poll = pq.poll();
                if (poll.length < 3) return false;
            }
            if (pq.isEmpty() || pq.peek().end == num) {
                pq.add(new Interval(num, num));
            } else {
                Interval poll = pq.poll();
                pq.add(new Interval(poll.start, poll.end + 1));
            }
        }
        while (!pq.isEmpty()) {
            if (pq.poll().length < 3) return false;
        }
        return true;
    }
}
