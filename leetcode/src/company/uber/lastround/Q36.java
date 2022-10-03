package company.uber.lastround;

import java.util.HashSet;
import java.util.Set;

public class Q36 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !set.add(board[i][j])) return false;
            }
        }
        for (int j = 0; j < 9; j++) {
            set.clear();
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.' && !set.add(board[i][j])) return false;
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                set.clear();
                for (int k = 0; k < 9; k++) {
                    if (board[i + k / 3][j + k % 3] != '.' && !set.add(board[i + k / 3][j + k % 3])) return false;
                }
            }
        }
        return true;
    }
}
