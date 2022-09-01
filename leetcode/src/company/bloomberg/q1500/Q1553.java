package company.bloomberg.q1500;

import java.util.*;

public class Q1553 {
    Map<Integer, Integer> memo = new HashMap<>();

    public int minDays(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        int res = Math.min(n % 2 + minDays(n / 2), n % 3 + minDays(n / 3)) + 1;
        memo.put(n, res);
        return res;
    }

    public int minDays1(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(n);
        visited.add(n);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (poll.equals(0)) return res;
                if (!visited.contains(poll - 1)) {
                    queue.add(poll - 1);
                    visited.add(poll - 1);
                }
                if (poll % 2 == 0 && !visited.contains(poll / 2)) {
                    queue.add(poll / 2);
                    visited.add(poll / 2);
                }
                if (poll % 3 == 0 && !visited.contains(poll / 3)) {
                    queue.add(poll / 3);
                    visited.add(poll / 3);
                }
            }
            res++;
        }
        return -1;
    }
}
