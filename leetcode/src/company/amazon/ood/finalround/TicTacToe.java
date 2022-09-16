package company.amazon.ood.finalround;

public class TicTacToe {
    class Player {
        String name;
    }

    class Unit {
        int row;
        int col;
        Player player;

        public Unit(int row, int col) {
            this.row = row;
            this.col = col;
        }

        boolean isEmpty() {
            return player == null;
        }
    }

    class Board {
        Unit[][] board;

        public Board(int n) {
            board = new Unit[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = new Unit(i, j);
                }
            }
        }

        public boolean canPut(int row, int col) {
            return board[row][col].isEmpty();
        }

        public void put(Player player, int row, int col) {
            board[row][col].player = player;
        }
    }

    class Game {
        int n;
        Board board;
        Player p1, p2;
        int[] rows;
        int[] cols;
        int diagonal;
        int antiDiagonal;
        Player currentTurn;
        boolean end = false;

        public Game(int n, Player p1, Player p2) {
            this.n = n;
            this.p1 = p1;
            this.p2 = p2;
            board = new Board(n);
            currentTurn = p1;
            rows = new int[n];
            cols = new int[n];
        }

        public void move(Player player, int row, int col) {
            if (end) return;
            if (player != currentTurn) return;
            if (!board.canPut(row, col)) return;
            board.put(player, row, col);
            updateGameStatus(player, row, col);
        }

        private void updateGameStatus(Player player, int row, int col) {
            int val = player == p1 ? 1 : -1;
            rows[row] += val;
            cols[col] += val;
            if (row == col) diagonal += val;
            if (n - 1 - row == col) diagonal += val;
            if (Math.abs(rows[row]) == n) {
                end = false;
            }
        }
    }
}
