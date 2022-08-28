package company.bloomberg.other;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinStepsToGenNumber {
    static int minSteps(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(n);
        queue.add(n);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (poll == 1) return res;
                int next = poll * 2;
                if (!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                }
                next = poll / 3;
                if (!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                }
            }
            res++;
        }
        return -1;
    }
}
