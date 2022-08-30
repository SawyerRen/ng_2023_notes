package company.bloomberg.q1200;

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
            if (!stack.isEmpty() && c == stack.getLast().ch) {
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

    public String removeDuplicatesMoreThanK(String s, int k) {
        LinkedList<Node> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (c == stack.peekLast().ch) {
                    stack.peekLast().count++;
                } else {
                    if (stack.peekLast().count >= k) {
                        stack.removeLast();
                    }
                    if (!stack.isEmpty() && stack.getLast().ch == c) {
                        stack.peekLast().count++;
                    } else {
                        stack.addLast(new Node(c, 1));
                    }
                }
            } else {
                stack.addLast(new Node(c, 1));
            }
        }
        if (stack.getLast().count >= k) stack.removeLast();
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
