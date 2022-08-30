package company.bloomberg.q1600;

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
                if (cur.children[s.charAt(j) - 'a'] == null) {
                    cur.children[s.charAt(j) - 'a'] = new Node();
                    res++;
                }
                cur = cur.children[s.charAt(j) - 'a'];
            }
        }
        return res;
    }
}
