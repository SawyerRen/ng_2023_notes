package company.expedia.oa;

import java.lang.annotation.Target;
import java.util.PriorityQueue;

public class BankTransaction {
    static int solution(int[] transactions) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cur = 0, remove = 0;
        for (int t : transactions) {
            if (t < 0) pq.add(t);
            cur += t;
            while (cur < 0 && !pq.isEmpty()) {
                cur -= pq.poll();
                remove++;
            }
        }
        return transactions.length - remove;
    }

    public static void main(String[] args) {
        int[] t = {3, 2, -5, -6, -1, 4};
        System.out.println(solution(t));
    }
}
