package company.bloomberg.q700;

public class Q723 {
    public int[][] candyCrush(int[][] board) {
        int m = board.length, n = board[0].length;
        boolean finished = true;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n - 1; j++) {
                int val = Math.abs(board[i][j]);
                if (val == 0) continue;
                if (val == Math.abs(board[i][j - 1]) && val == Math.abs(board[i][j + 1])) {
                    board[i][j - 1] = board[i][j] = board[i][j + 1] = -val;
                    finished = false;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m - 1; i++) {
                int val = Math.abs(board[i][j]);
                if (val == 0) continue;
                if (val == Math.abs(board[i - 1][j]) && val == Math.abs(board[i + 1][j])) {
                    board[i - 1][j] = board[i][j] = board[i + 1][j] = -val;
                    finished = false;
                }
            }
        }
        for (int col = 0; col < n; col++) {
            int row = m - 1;
            int i = m - 1;
            while (i >= 0) {
                if (board[i][col] > 0) {
                    board[row--][col] = board[i][col];
                }
                i--;
            }
            while (row >= 0) {
                board[row--][col] = 0;
            }
        }
        return finished ? board : candyCrush(board);
    }
}
