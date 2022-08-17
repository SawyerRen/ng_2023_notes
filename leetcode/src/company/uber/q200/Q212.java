package company.uber.q200;

import java.util.*;

public class Q212 {
    class Node {
        String word = null;
        Node[] children = new Node[26];
    }

    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        for (String word : words) {
            addToTrie(root, word);
        }
        Set<String> res = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(res, board, i, j, root);
            }
        }
        return new ArrayList<>(res);
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void dfs(Set<String> res, char[][] board, int i, int j, Node node) {
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) return;
        node = node.children[c - 'a'];
        if (node.word != null) {
            res.add(node.word);
        }
        board[i][j] = '#';
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) continue;
            dfs(res, board, x, y, node);
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
