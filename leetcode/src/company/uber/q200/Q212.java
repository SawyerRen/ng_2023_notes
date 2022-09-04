package company.uber.q200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q212 {
    class Node {
        String word;
        Node[] children = new Node[26];
    }

    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        addToTrie(root, words);
        int m = board.length, n = board[0].length;
        Set<String> set = new HashSet<>();
        Node cur = root;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, m, n, cur, set);
            }
        }
        return new ArrayList<>(set);
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void dfs(char[][] board, int i, int j, int m, int n, Node cur, Set<String> set) {
        char c = board[i][j];
        if (cur.children[c - 'a'] == null) return;
        cur = cur.children[c - 'a'];
        if (cur.word != null) set.add(cur.word);
        board[i][j] = '#';
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] == '#') continue;
            dfs(board, x, y, m, n, cur, set);
        }
        board[i][j] = c;
    }

    private void addToTrie(Node root, String[] words) {
        for (String word : words) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node();
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }
    }
}
