package company.uber.goodluck;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q212 {
    class Node {
        Node[] children = new Node[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        for (String word : words) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node();
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }
        Set<String> set = new HashSet<>();
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                helper(set, root, board, i, j, m, n);
            }
        }
        return new ArrayList<>(set);
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void helper(Set<String> set, Node cur, char[][] board, int i, int j, int m, int n) {
        char c = board[i][j];
        cur = cur.children[c - 'a'];
        if (cur == null) return;
        if (cur.word != null) set.add(cur.word);
        board[i][j] = '#';
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] == '#') continue;
            helper(set, cur, board, x, y, m, n);
        }
        board[i][j] = c;
    }
}
