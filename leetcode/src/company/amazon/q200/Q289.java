package company.amazon.q200;

public class Q289 {
    int Live = 1;
    int Dead = 0;
    int Live2Dead = 2;
    int Dead2Live = 3;

    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countLiving(board, i, j, m, n);
                if ((count < 2 || count > 3) && board[i][j] == Live) {
                    board[i][j] = Live2Dead;
                }
                if (count == 3 && board[i][j] == Dead) {
                    board[i][j] = Dead2Live;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == Dead2Live) board[i][j] = Live;
                else if (board[i][j] == Live2Dead) board[i][j] = Dead;
            }
        }
    }

    private int countLiving(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        for (int k = -1; k <= 1; k++) {
            for (int l = -1; l <= 1; l++) {
                if (k == 0 && l == 0) continue;
                int x = i + k, y = j + l;
                if (x < 0 || x >= m || y < 0 || y >= n) continue;
                if (board[x][y] == Live || board[x][y] == Live2Dead) count++;
            }
        }
        return count;
    }
}
