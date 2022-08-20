package company.amazon.q300;

public class Q348 {
    class TicTacToe {
        int[] rows;
        int[] cols;
        int n;
        int diagonal;
        int antiDiagonal;

        public TicTacToe(int n) {
            this.n = n;
            rows = new int[n];
            cols = new int[n];
        }

        public int move(int row, int col, int player) {
            int value = player == 1 ? 1 : -1;
            rows[row] += value;
            cols[col] += value;
            if (row == col) diagonal += value;
            if (row == n - 1 - col) antiDiagonal += value;
            if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n
                    || Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n) {
                return player;
            }
            return 0;
        }
    }
}
