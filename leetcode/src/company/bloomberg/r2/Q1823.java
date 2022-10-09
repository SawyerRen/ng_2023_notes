package company.bloomberg.r2;

import java.util.LinkedList;
import java.util.Queue;

public class Q1823 {
    public int findTheWinner(int n, int k) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + k) % i;
        }
        return res + 1;
    }

    public int findTheWinner1(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            int temp = k;
            while (temp-- > 1) {
                queue.add(queue.poll());
            }
            queue.poll();
        }
        return queue.peek();
    }
}
