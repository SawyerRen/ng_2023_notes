package company.uber.lastround;

import java.util.PriorityQueue;

public class Q855 {
    class ExamRoom {
        PriorityQueue<int[]> pq;
        int n;

        int calDist(int[] interval) {
            if (interval[0] == -1) return interval[1];
            if (interval[1] == n) return n - 1 - interval[0];
            return (interval[1] - interval[0]) / 2;
        }

        public ExamRoom(int n) {
            this.n = n;
            pq = new PriorityQueue<>((a, b) -> {
                int d1 = calDist(a);
                int d2 = calDist(b);
                if (d1 == d2) return a[0] - b[0];
                return d2 - d1;
            });
            pq.add(new int[]{-1, n});
        }

        public int seat() {
            int seat = -1;
            int[] poll = pq.poll();
            if (poll[0] == -1) seat = 0;
            else if (poll[1] == n) seat = n - 1;
            else seat = poll[0] + (poll[1] - poll[0]) / 2;
            pq.add(new int[]{poll[0], seat});
            pq.add(new int[]{seat, poll[1]});
            return seat;
        }

        public void leave(int p) {
            int[] left = null, right = null;
            for (int[] interval : pq) {
                if (interval[0] == p) {
                    right = interval;
                } else if (interval[1] == p) {
                    left = interval;
                }
            }
            pq.remove(left);
            pq.remove(right);
            pq.add(new int[]{left[0], right[1]});
        }
    }
}
