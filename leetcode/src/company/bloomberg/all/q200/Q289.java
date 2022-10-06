package company.bloomberg.all.q200;

public class Q289 {
    int living = 1;
    int dead = 0;
    int living2Dead = 3;
    int dead2Living = 4;

    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int livingCount = getLivingCount(board, i, j, m, n);
                if (livingCount < 2 || livingCount > 3) {
                    board[i][j] = board[i][j] == living ? living2Dead : dead;
                }
                if (livingCount == 3 && board[i][j] == dead) {
                    board[i][j] = dead2Living;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == living2Dead) board[i][j] = dead;
                else if (board[i][j] == dead2Living) board[i][j] = living;
            }
        }
    }

    private int getLivingCount(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                if (k == 0 && l == 0) continue;
                int x = i + k, y = j + l;
                if (x < 0 || x >= m || y < 0 || y >= n) continue;
                if (board[x][y] == living || board[x][y] == living2Dead) count++;
            }
        }
        return count;
    }
}
