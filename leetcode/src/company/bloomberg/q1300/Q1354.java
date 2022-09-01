package company.bloomberg.q1300;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1354 {
    public boolean isPossible(int[] target) {
        if (target.length == 1) return target[0] == 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;
        for (int i : target) {
            pq.add(i);
            sum += i;
        }
        while (!pq.isEmpty() && pq.peek() > 1) {
            int largest = pq.poll();
            int rest = sum - largest;
            if (rest == 1) return true;
            int x = largest % rest;
            if (x == 0 || x == largest) return false;
            pq.add(x);
            sum = sum - largest + x;
        }
        return true;
    }
}
