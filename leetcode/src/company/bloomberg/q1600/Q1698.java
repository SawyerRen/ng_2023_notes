package company.bloomberg.q1600;

public class Q1698 {
    class Node {
        Node[] children = new Node[26];
    }

    public int countDistinct(String s) {
        Node root = new Node();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            Node cur = root;
            for (int j = i; j < s.length(); j++) {
                if (cur.children[s.charAt(j) - 'a'] == null) {
                    count++;
                    cur.children[s.charAt(j) - 'a'] = new Node();
                }
                cur = cur.children[s.charAt(j) - 'a'];
            }
        }
        return count;
    }
}
