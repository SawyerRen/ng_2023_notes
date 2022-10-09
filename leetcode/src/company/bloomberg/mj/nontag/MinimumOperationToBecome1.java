package company.bloomberg.mj.nontag;

import java.util.*;

public class MinimumOperationToBecome1 {
    Map<Integer, Integer> map = new HashMap<>();

    int solution1(int n) {
        if (n == 1) return 0;
        if (map.containsKey(n)) return map.get(n);
        int res = Integer.MAX_VALUE;
        res = Math.min(res, solution1(n * 2) + 1);
        res = Math.min(res, solution1(n / 3) + 1);
        map.put(n, res);
        return res;
    }

    int solution2(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(n);
        visited.add(n);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (poll == 1) return res;
                if (!visited.contains(poll * 2)) {
                    visited.add(poll * 2);
                    queue.add(poll * 2);
                }
                if (poll % 3 == 0 && !visited.contains(poll / 3)) {
                    visited.add(poll / 3);
                    queue.add(poll / 3);
                }
            }
        }
        return -1;
    }
}
