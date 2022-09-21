package company.uber.q200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q279 {
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            list.add(i * i);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (poll == 0) return res;
                for (Integer num : list) {
                    int remain = poll - num;
                    if (remain < 0) break;
                    if (visited[remain]) continue;
                    queue.add(remain);
                    visited[remain] = true;
                }
            }
            res++;
        }
        return res;
    }
}
