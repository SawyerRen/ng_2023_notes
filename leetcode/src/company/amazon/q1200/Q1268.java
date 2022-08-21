package company.amazon.q1200;

import java.util.*;

public class Q1268 {
    class Node {
        Node[] children = new Node[26];
        List<String> list = new ArrayList<>();
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Node root = new Node();
        for (String product : products) {
            addToTrie(product, root);
        }
        List<List<String>> res = new ArrayList<>();
        Node cur = root;
        boolean notFound = false;
        for (char c : searchWord.toCharArray()) {
            if (notFound) {
                res.add(new ArrayList<>());
                continue;
            }
            cur = cur.children[c - 'a'];
            if (cur != null) {
                List<String> list = new ArrayList<>(cur.list);
                res.add(list);
            } else {
                res.add(new ArrayList<>());
                notFound = true;
            }
        }
        return res;
    }

    private void addToTrie(String s, Node root) {
        Node cur = root;
        for (char c : s.toCharArray()) {
            if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node();
            cur = cur.children[c - 'a'];
            if (cur.list.size() < 3) cur.list.add(s);
        }
    }
}
