package company.bloomberg.goodluck;

import java.util.LinkedList;
import java.util.Queue;

public class Q1823 {
    public int findTheWinner(int n, int k) {
        int res = 0;
        for (int total = 2; total <= n; total++) {
            res = (res + k) % total;
        }
        return res + 1;
    }

    public int findTheWinner1(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }
        while (queue.size() > 1) {
            int temp = k;
            while (temp-- > 1) {
                queue.add(queue.poll());
            }
            queue.poll();
        }
        return queue.poll();
    }
}
