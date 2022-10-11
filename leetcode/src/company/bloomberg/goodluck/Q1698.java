package company.bloomberg.goodluck;

public class Q1698 {
    class Node {
        Node[] children = new Node[26];
    }

    public int countDistinct(String s) {
        Node root = new Node();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Node cur = root;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Node();
                    res++;
                }
                cur = cur.children[c - 'a'];
            }
        }
        return res;
    }
}
