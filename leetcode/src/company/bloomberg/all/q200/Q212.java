package company.bloomberg.all.q200;

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
        Set<String> set = new HashSet<>();
        Node root = new Node();
        for (String word : words) {
            addToTrie(root, word);
        }
        int m = board.length, n = board[0].length;
        Node cur = root;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(set, cur, board, i, j, m, n);
            }
        }
        return new ArrayList<>(set);
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void dfs(Set<String> set, Node cur, char[][] board, int i, int j, int m, int n) {
        char c = board[i][j];
        if (c == '#' || cur.children[c - 'a'] == null) return;
        cur = cur.children[c - 'a'];
        if (cur.word != null) set.add(cur.word);
        board[i][j] = '#';
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n) continue;
            dfs(set, cur, board, x, y, m, n);
        }
        board[i][j] = c;
    }

    private void addToTrie(Node root, String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node();
            cur = cur.children[c - 'a'];
        }
        cur.word = word;
    }
}
