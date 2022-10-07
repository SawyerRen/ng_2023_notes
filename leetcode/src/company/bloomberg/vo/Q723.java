package company.bloomberg.vo;

public class Q723 {
    public int[][] candyCrush(int[][] board) {
        int m = board.length, n = board[0].length;
        boolean finish = true;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n - 1; j++) {
                int v = Math.abs(board[i][j]);
                if (v == 0) continue;
                if (Math.abs(board[i][j - 1]) == v && Math.abs(board[i][j + 1]) == v) {
                    board[i][j - 1] = board[i][j] = board[i][j + 1] = -v;
                    finish = false;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m - 1; i++) {
                int v = Math.abs(board[i][j]);
                if (v == 0) continue;
                if (Math.abs(board[i - 1][j]) == v && Math.abs(board[i + 1][j]) == v) {
                    board[i - 1][j] = board[i][j] = board[i + 1][j] = -v;
                    finish = false;
                }
            }
        }
        for (int col = 0; col < n; col++) {
            int index = m - 1;
            for (int row = m - 1; row >= 0; row--) {
                if (board[row][col] > 0) {
                    board[index--][col] = board[row][col];
                }
            }
            while (index >= 0) {
                board[index--][col] = 0;
            }
        }
        if (finish) return board;
        return candyCrush(board);
    }
}
