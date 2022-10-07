package company.bloomberg.vo;

public class Q1698 {
    class Node {
        Node[] children = new Node[26];
    }

    public int countDistinct(String s) {
        int res = 0;
        Node root = new Node();
        for (int i = 0; i < s.length(); i++) {
            Node cur = root;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (cur.children[c - 'a'] == null) {
                    res++;
                    cur.children[c - 'a'] = new Node();
                }
                cur = cur.children[c - 'a'];
            }
        }
        return res;
    }
}
