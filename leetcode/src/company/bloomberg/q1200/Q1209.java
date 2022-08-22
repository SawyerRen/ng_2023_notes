package company.bloomberg.q1200;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Q1209 {
    class Node {
        char c;
        int count;

        public Node() {
        }

        public Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {
        Deque<Node> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peekLast().c) {
                stack.peekLast().count++;
                if (stack.peekLast().count == k) stack.removeLast();
            } else {
                stack.addLast(new Node(c, 1));
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            Node node = stack.removeFirst();
            for (int i = 0; i < node.count; i++) {
                builder.append(node.c);
            }
        }
        return builder.toString();
    }
}
