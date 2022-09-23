package company.uber.other1;

public class BreakingBad {
    class Node {
        String word;
        Node[] children = new Node[256];
    }

    String solution(String s, String[] symbols) {
        Node root = new Node();
        for (String symbol : symbols) {
            Node cur = root;
            for (char c : symbol.toCharArray()) {
                if (cur.children[c] == null) cur.children[c] = new Node();
                cur = cur.children[c];
            }
            cur.word = symbol;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Node cur = root;
            if (cur.children[c] == null) {
                builder.append(c);
                continue;
            }
            int right = i;
            builder.append("[");
            while (right < s.length() && cur.children[s.charAt(right)] != null) {
                cur = cur.children[s.charAt(right)];
                right++;
            }
            builder.append(cur.word);
            i = right - 1;
        }
        return builder.toString();
    }
}
