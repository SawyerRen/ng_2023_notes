package company.uber.q0;

public class Q79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, word, i, j, m, n, 0)) return true;
            }
        }
        return false;
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private boolean search(char[][] board, String word, int i, int j, int m, int n, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(index)) return false;
        board[i][j] = '#';
        for (int[] dir : dirs) {
            if (search(board, word, i + dir[0], j + dir[1], m, n, index + 1)) return true;
        }
        board[i][j] = word.charAt(index);
        return false;
    }
}
