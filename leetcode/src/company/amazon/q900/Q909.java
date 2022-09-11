package company.amazon.q900;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        queue.add(1);
        visited[1] = true;
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer cur = queue.poll();
                List<Integer> nextList = getNext(board, cur);
                for (Integer next : nextList) {
                    if (next >= n * n) return res;
                    if (visited[next]) continue;
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
        return -1;
    }

    private List<Integer> getNext(int[][] board, Integer cur) {
        int n = board.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            int next = cur + i;
            if (next >= n * n) {
                list.add(next);
                return list;
            }
            int row = n - (next - 1) / n - 1;
            boolean reverse = (n - row) % 2 == 0;
            int col = reverse ? n - (next - 1) % n - 1 : (next - 1) % n;
            if (board[row][col] == -1) list.add(next);
            else list.add(board[row][col]);
        }
        return list;
    }
}
