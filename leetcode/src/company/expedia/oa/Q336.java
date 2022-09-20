package company.expedia.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q336 {
    class Node {
        Node[] children = new Node[26];
        int index = -1;
        List<Integer> list = new ArrayList<>();
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Node root = new Node();
        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            search(words, i, root, res);
        }
        return res;
    }

    private void search(String[] words, int i, Node root, List<List<Integer>> res) {
        for (int j = 0; j < words[i].length(); j++) {
            if (root.index >= 0 && root.index != i && isPal(words[i], j, words[i].length() - 1)) {
                res.add(Arrays.asList(i, root.index));
            }
            root = root.children[words[i].charAt(j) - 'a'];
            if (root == null) return;
        }
        for (Integer j : root.list) {
            if (i == j) continue;
            res.add(Arrays.asList(i, j));
        }
    }

    private void addWord(Node root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (root.children[c - 'a'] == null) root.children[c - 'a'] = new Node();
            if (isPal(word, 0, i)) {
                root.list.add(index);
            }
            root = root.children[c - 'a'];
        }
        root.list.add(index);
        root.index = index;
    }

    private boolean isPal(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }
        return true;
    }
}
