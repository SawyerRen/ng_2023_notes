package company.amazon.q900;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] visited = new boolean[n * n + 1];
        visited[1] = true;
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                for (int j = 0; j < 6; j++) {
                    int next = poll + j;
                    int[] pos = numToPos(next, n);
                    if (board[pos[0]][pos[1]] > 0) {
                        next = board[pos[0]][pos[1]];
                    }
                    if (next == n * n) return res;
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            res++;
        }
        return -1;
    }

    private int[] numToPos(int next, int n) {
        int row = (next - 1) / n;
        int col = (next - 1) % n;
        int x = n - row - 1;
        int y = row % 2 == 0 ? col : n - 1 - col;
        return new int[]{x, y};
    }

    private List<Integer> getNext(int[][] board, int cur) {
        List<Integer> list = new ArrayList<>();
        int n = board.length;
        for (int i = 1; i <= 6; i++) {
            int next = cur + i;
            if (next > n * n) {
                list.add(next);
                return list;
            }
            int row = n - (next - 1) / n - 1;
            boolean reverse = (next / n) % 2 == 1;
            int col = reverse ? (n - (next - 1) % n) - 1 : (next - 1) % n;
            if (board[row][col] == -1) list.add(next);
            else list.add(board[row][col]);
        }
        return list;
    }
}
