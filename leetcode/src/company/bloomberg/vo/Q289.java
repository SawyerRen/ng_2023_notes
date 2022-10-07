package company.bloomberg.vo;

public class Q289 {
    int dead = 0, live = 1, live2Dead = 2, dead2Live = 3;

    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = getCount(board, i, j, m, n);
                if (board[i][j] == live) {
                    if (count < 2 || count > 3) board[i][j] = live2Dead;
                }
                if (board[i][j] == dead && count == 3) board[i][j] = dead2Live;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == live2Dead) board[i][j] = dead;
                else if (board[i][j] == dead2Live) board[i][j] = live;
            }
        }
    }

    private int getCount(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                if (k == 0 && l == 0) continue;
                int x = i + k, y = j + l;
                if (x < 0 || x >= m || y < 0 || y >= n) continue;
                if (board[x][y] == live || board[x][y] == live2Dead) count++;
            }
        }
        return count;
    }
}
