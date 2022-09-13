package company.amazon.q1200;

import java.util.LinkedList;
import java.util.Stack;

public class Q1209 {
    class Node {
        char ch;
        int count;

        public Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {
        LinkedList<Node> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.getLast().ch == c) {
                stack.getLast().count++;
                if (stack.getLast().count == k) stack.removeLast();
            } else {
                stack.addLast(new Node(c, 1));
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
