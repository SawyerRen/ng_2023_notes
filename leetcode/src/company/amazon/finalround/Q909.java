package company.amazon.finalround;

import java.util.*;

public class Q909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(1);
        visited.add(1);
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                List<Integer> nextList = getNext(board, poll);
                for (Integer next : nextList) {
                    if (next >= n * n) return res;
                    if (visited.contains(next)) continue;
                    queue.add(next);
                    visited.add(next);
                }
            }
        }
        return -1;
    }

    private List<Integer> getNext(int[][] board, Integer num) {
        int n = board.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            int next = num + i;
            if (next >= n * n) {
                list.add(next);
                return list;
            }
            int row = n - 1 - (next - 1) / n;
            boolean reverse = (n - row) % 2 == 0;
            int col = reverse ? n - 1 - (next - 1) % n : (next - 1) % n;
            if (board[row][col] != -1) {
                list.add(board[row][col]);
            } else {
                list.add(next);
            }
        }
        return list;
    }
}
