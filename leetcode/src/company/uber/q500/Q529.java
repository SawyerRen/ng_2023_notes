package company.uber.q500;

import java.util.LinkedList;
import java.util.Queue;

public class Q529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int count = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    int x = poll[0] + i, y = poll[1] + j;
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    if (board[x][y] == 'M' || board[x][y] == 'X') count++;
                }
            }
            if (count > 0) {
                board[poll[0]][poll[1]] = (char) (count + '0');
                continue;
            }
            board[poll[0]][poll[1]] = 'B';
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    int x = poll[0] + i, y = poll[1] + j;
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    if (board[x][y] == 'E') {
                        queue.add(new int[]{x, y});
                        board[x][y] = 'B';
                    }
                }
            }
        }
        return board;
    }
}
