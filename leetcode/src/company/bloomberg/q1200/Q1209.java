package company.bloomberg.q1200;

import java.util.LinkedList;
import java.util.Stack;

public class Q1209 {
    class Node {
        int count;
        char ch;

        public Node(int count, char ch) {
            this.count = count;
            this.ch = ch;
        }
    }

    public String removeDuplicates(String s, int k) {
        LinkedList<Node> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peekLast().ch == c) {
                stack.peekLast().count++;
                if (stack.peekLast().count >= k) stack.removeLast();
            } else {
                stack.addLast(new Node(1, c));
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            Node node = stack.removeFirst();
            for (int i = 0; i < node.count; i++) {
                builder.append(node.ch);
            }
        }
        return builder.toString();
    }
}
