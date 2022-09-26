package company.uber.all1;

import java.util.*;

public class Q279 {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(n);
        visited[n] = true;
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i < n + 1; i++) {
            list.add(i * i);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (poll == 0) return res;
                for (Integer num : list) {
                    if (num > poll) break;
                    int next = poll - num;
                    if (visited[next]) continue;
                    queue.add(next);
                    visited[next] = true;
                }
            }
            res++;
        }
        return -1;
    }

    public int numSquares1(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i < n + 1; i++) {
            list.add(i * i);
        }
        for (int i = 1; i < n + 1; i++) {
            for (Integer num : list) {
                if (num > i) break;
                if (i >= num && dp[i - num] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - num] + 1);
                }
            }
        }
        return dp[n];
    }
}
