package company.bloomberg.all.q700;

public class Q723 {
    public int[][] candyCrush(int[][] board) {
        int m = board.length, n = board[0].length;
        boolean finished = true;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n - 1; j++) {
                int val = Math.abs(board[i][j]);
                if (val != 0 && Math.abs(board[i][j - 1]) == val && Math.abs(board[i][j + 1]) == val) {
                    board[i][j - 1] = board[i][j] = board[i][j + 1] = -val;
                    finished = false;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m - 1; i++) {
                int val = Math.abs(board[i][j]);
                if (val != 0 && Math.abs(board[i - 1][j]) == val && Math.abs(board[i + 1][j]) == val) {
                    board[i - 1][j] = board[i][j] = board[i + 1][j] = -val;
                    finished = false;
                }
            }
        }
        for (int col = 0; col < n; col++) {
            int pointer = m - 1;
            for (int row = m - 1; row >= 0; row--) {
                if (board[row][col] > 0) {
                    board[pointer--][col] = board[row][col];
                }
            }
            for (int row = 0; row <= pointer; row++) {
                board[row][col] = 0;
            }
        }
        return finished ? board : candyCrush(board);
    }
}
