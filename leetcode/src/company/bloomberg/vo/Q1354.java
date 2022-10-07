package company.bloomberg.vo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1354 {
    public boolean isPossible(int[] target) {
        if (target.length == 1) return target[0] == 1;
        int total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : target) {
            total += i;
            pq.add(i);
        }
        while (!pq.isEmpty() && pq.peek() > 1) {
            Integer largest = pq.poll();
            int remain = total - largest;
            if (remain == 1) return true;
            int x = largest % remain;
            if (x == largest || x == 0) return false;
            pq.add(x);
            total = total - largest + x;
        }
        return true;
    }
}
