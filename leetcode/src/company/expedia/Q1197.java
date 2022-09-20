package company.expedia;

import java.util.*;

public class Q1197 {
    int[][] dirs = {{1, 2}, {2, 1}, {2, -1}, {1, -2},
            {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};


    public int minKnightMoves(int x, int y) {
        Map<String, Integer> memo = new HashMap<>();
        return helper(memo, Math.abs(x), Math.abs(y));
    }

    private int helper(Map<String, Integer> memo, int x, int y) {
        String s = x + "," + y;
        if (memo.containsKey(s)) return memo.get(s);
        if (x == 0 && y == 0) return 0;
        if (x + y == 2) return 2;
        int res = Math.min(helper(memo, Math.abs(x - 1), Math.abs(y - 2)), helper(memo, Math.abs(x - 2), Math.abs(y - 1))) + 1;
        memo.put(s, res);
        return res;
    }

    public int minKnightMoves1(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new int[]{0, 0});
        visited.add(0 + "," + 0);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if (poll[0] == x && poll[1] == y) return res;
                for (int[] dir : dirs) {
                    int row = poll[0] + dir[0], col = poll[1] + dir[1];
                    if (row < -1 || col < -1 || visited.contains(row + "," + col)) continue;
                    queue.add(new int[]{row, col});
                    visited.add(row + "," + col);
                }
            }
            res++;
        }
        return -1;
    }
}
