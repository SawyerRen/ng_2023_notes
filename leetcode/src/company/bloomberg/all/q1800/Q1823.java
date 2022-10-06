package company.bloomberg.all.q1800;

import java.util.LinkedList;
import java.util.Queue;

public class Q1823 {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }
        while (queue.size() > 1) {
            int temp = k;
            while (temp > 1) {
                queue.add(queue.poll());
                temp--;
            }
            queue.poll();
        }
        return queue.peek();
    }
}
