package company.uber.q800;

import java.util.PriorityQueue;

public class Q855 {
    class ExamRoom {
        PriorityQueue<int[]> pq;
        int n;

        int calDist(int[] interval) {
            if (interval[0] == -1) {
                return interval[1];
            } else if (interval[1] == n) {
                return n - 1 - interval[0];
            } else {
                return (interval[1] - interval[0]) / 2;
            }
        }

        public ExamRoom(int n) {
            this.n = n;
            pq = new PriorityQueue<>((a, b) -> {
                int distA = calDist(a);
                int distB = calDist(b);
                if (distA == distB) return a[0] - b[0];
                return distB - distA;
            });
            pq.add(new int[]{-1, n});
        }

        public int seat() {
            int seat = 0;
            int[] poll = pq.poll();
            if (poll[0] == -1) seat = 0;
            else if (poll[1] == n) seat = n - 1;
            else seat = poll[0] + (poll[1] - poll[0]) / 2;
            pq.add(new int[]{poll[0], seat});
            pq.add(new int[]{seat, poll[1]});
            return seat;
        }

        public void leave(int p) {
            int[] prev = null;
            int[] next = null;
            for (int[] interval : pq) {
                if (interval[0] == p) {
                    next = interval;
                }
                if (interval[1] == p) {
                    prev = interval;
                }
            }
            pq.remove(next);
            pq.remove(prev);
            pq.add(new int[]{prev[0], next[1]});
        }
    }
}
