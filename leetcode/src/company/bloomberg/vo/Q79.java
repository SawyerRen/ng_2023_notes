package company.bloomberg.vo;

public class Q79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, i, j, m, n, word, 0)) return true;
            }
        }
        return false;
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private boolean helper(char[][] board, int i, int j, int m, int n, String word, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(index)) return false;
        board[i][j] = '#';
        for (int[] dir : dirs) {
            if (helper(board, i + dir[0], j + dir[1], m, n, word, index + 1)) return true;
        }
        board[i][j] = word.charAt(index);
        return false;
    }
}
