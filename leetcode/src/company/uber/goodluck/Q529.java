package company.uber.goodluck;

import java.util.LinkedList;
import java.util.Queue;

public class Q529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1];
            int count = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) continue;
                    int nx = i + x, ny = j + y;
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    if (board[nx][ny] == 'M' || board[nx][ny] == 'X') count++;
                }
            }
            if (count > 0) {
                board[x][y] = (char) (count + '0');
                continue;
            }
            board[x][y] = 'B';
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) continue;
                    int nx = i + x, ny = j + y;
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    if (board[nx][ny] == 'E') {
                        board[nx][ny] = 'B';
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return board;
    }
}
