package company.uber.q500;

import java.util.LinkedList;
import java.util.Queue;

public class Q529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        int m = board.length, n = board[0].length;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int countMine = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue;
                    int x = poll[0] + i, y = poll[1] + j;
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    if (board[x][y] == 'M' || board[x][y] == 'X') countMine++;
                }
            }
            if (countMine > 0) {
                board[poll[0]][poll[1]] = (char) (countMine + '0');
                continue;
            }
            board[poll[0]][poll[1]] = 'B';
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue;
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
