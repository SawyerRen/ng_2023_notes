package company.uber.other;

public class BreakingBad {
    static class Node {
        String word;
        Node[] children = new Node[128];
    }

    static String solution(String s, String[] symbols) {
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
            Node cur = root;
            if (cur.children[s.charAt(i)] == null) {
                builder.append(s.charAt(i));
                continue;
            }
            int left = i, right = i;
            while (right < s.length() && cur.children[s.charAt(right)] != null) {
                cur = cur.children[s.charAt(right)];
                right++;
            }
            if (cur.word != null) {
                builder.append("[").append(cur.word).append("]");
            }
            i = right - 1;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String[] symbols = {"H", "He", "Al", "Si", "Fa"};
        System.out.println(solution("Henry Alba", symbols));
    }
}
