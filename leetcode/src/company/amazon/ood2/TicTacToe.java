package company.amazon.ood2;

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
            return this.player == null;
        }

        void setPlayer(Player player) {
            this.player = player;
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
            board[row][col].setPlayer(player);
        }
    }

    enum GameStatus {
        PLAYER1_WON, PLAYER2_WON, GOING_ON
    }

    class Game {
        int n;
        Board board;
        Player player1;
        Player player2;
        GameStatus status;
        int[] rows;
        int[] cols;
        int diagonal;
        int antiDiagonal;

        public Game(int n, Player player1, Player player2) {
            this.n = n;
            this.player1 = player1;
            this.player2 = player2;
            board = new Board(n);
            status = GameStatus.GOING_ON;
            rows = new int[n];
            cols = new int[n];
        }

        public Player put(Player player, int row, int col) {
            if (status != GameStatus.GOING_ON) return null;
            if (!board.canPut(row, col)) return null;
            board.put(player, row, col);
            return updateStatus(player, row, col);
        }

        private Player updateStatus(Player player, int row, int col) {
            int val = player == player1 ? 1 : -1;
            rows[row] += val;
            cols[col] += val;
            if (row == col) diagonal += val;
            if (row == n - 1 - col) antiDiagonal -= val;
            if (rows[row] == n || cols[col] == n || diagonal == n || antiDiagonal == n) {
                if (player == player1) {
                    this.status = GameStatus.PLAYER1_WON;
                } else {
                    this.status = GameStatus.PLAYER2_WON;
                }
            }
            return null;
        }
    }
}
