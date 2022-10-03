package company.uber.lastround;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q279 {
    public int numSquares(int n) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i * i < n + 1; i++) {
            nums.add(i * i);
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
                for (Integer num : nums) {
                    if (num > poll) break;
                    if (visited[poll - num]) continue;
                    queue.add(poll - num);
                    visited[poll - num] = true;
                }
            }
            res++;
        }
        return -1;
    }
}
