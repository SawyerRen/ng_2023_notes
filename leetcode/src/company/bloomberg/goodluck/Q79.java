package company.bloomberg.goodluck;

public class Q79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        // 遍历matrix，从每一个点出发看能不能组成word
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, i, j, m, n, word, 0)) return true;
            }
        }
        return false;
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    // 标准的dfs写法
    private boolean helper(char[][] board, int i, int j, int m, int n, String word, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(index)) return false;
        board[i][j] = '#'; // 这里没有用visited来表示一个位置有没有访问过，而是把这个位置的字符改成#，这种写法可以省一些空间
        for (int[] dir : dirs) {
            if (helper(board, i + dir[0], j + dir[1], m, n, word, index + 1)) return true;
        }
        board[i][j] = word.charAt(index);
        return false;
    }
}
