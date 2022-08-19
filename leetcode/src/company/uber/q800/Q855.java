package company.uber.q800;

import java.util.PriorityQueue;

public class Q855 {
    class ExamRoom {
        PriorityQueue<int[]> pq;
        int n;

        int calDist(int[] interval) {
            int dist = 0;
            if (interval[0] == -1) {
                dist = interval[1];
            } else if (interval[1] == n) {
                dist = n - 1 - interval[0];
            } else {
                dist = (interval[1] - interval[0]) / 2;
            }
            return dist;
        }

        public ExamRoom(int n) {
            this.n = n;
            pq = new PriorityQueue<>((a, b) -> {
                if (calDist(a) == calDist(b)) return a[0] - b[0];
                return calDist(b) - calDist(a);
            });
            pq.add(new int[]{-1, n});
        }

        public int seat() {
            int seat = 0;
            int[] poll = pq.poll();
            if (poll[0] == -1) {
                seat = 0;
            } else if (poll[1] == n) {
                seat = n - 1;
            } else {
                seat = poll[0] + calDist(poll);
            }
            pq.add(new int[]{poll[0], seat});
            pq.add(new int[]{seat, poll[1]});
            return seat;
        }

        public void leave(int p) {
            int[] left = null, right = null;
            for (int[] interval : pq) {
                if (interval[0] == p) {
                    right = interval;
                }
                if (interval[1] == p) {
                    left = interval;
                }
            }
            pq.remove(left);
            pq.remove(right);
            pq.add(new int[]{left[0], right[1]});
        }
    }
}
