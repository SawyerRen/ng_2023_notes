package company.bloomberg.q0;

public class Q79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0, m, n)) return true;
            }
        }
        return false;
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private boolean dfs(char[][] board, int i, int j, String word, int index, int m, int n) {
        if (index == word.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(index)) return false;
        board[i][j] = '#';
        for (int[] dir : dirs) {
            if (dfs(board, i + dir[0], j + dir[1], word, index + 1, m, n)) return true;
        }
        board[i][j] = word.charAt(index);
        return false;
    }
}
