package company.uber.all1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q51 {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        List<List<String>> res = new ArrayList<>();
        helper(res, board, 0);
        return res;
    }

    private void helper(List<List<String>> res, char[][] board, int row) {
        if (row == board.length) {
            res.add(toList(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (valid(board, row, col)) {
                board[row][col] = 'Q';
                helper(res, board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private boolean valid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'Q') {
                    if (col == j || Math.abs(row - i) == Math.abs(col - j)) return false;
                }
            }
        }
        return true;
    }

    private List<String> toList(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            StringBuilder builder = new StringBuilder();
            for (char c : row) {
                builder.append(c);
            }
            list.add(builder.toString());
        }
        return list;
    }
}
