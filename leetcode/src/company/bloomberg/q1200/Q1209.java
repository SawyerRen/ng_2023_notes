package company.bloomberg.q1200;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Q1209 {
    static class Node {
        char c;
        int count;

        public Node() {
        }

        public Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    static public String removeDuplicates(String s, int k) {
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

    public static String followUp(String s, int k) {
        Deque<Node> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (c == stack.peekLast().c) {
                    stack.peekLast().count++;
                } else {
                    while (!stack.isEmpty() && stack.peekLast().count >= k) {
                        stack.removeLast();
                    }
                    if (!stack.isEmpty() && stack.peekLast().c == c) {
                        stack.peekLast().count++;
                    } else {
                        stack.addLast(new Node(c, 1));
                    }
                }
            } else {
                stack.addLast(new Node(c, 1));
            }
        }
        if (stack.isEmpty()) return "";
        if (stack.peekLast().count >= k) stack.removeLast();
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            Node node = stack.removeFirst();
            for (int i = 0; i < node.count; i++) {
                builder.append(node.c);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("aaabbccbcccbba", 3));
        System.out.println(removeDuplicates("aaabbbccbcccbba", 2));
        System.out.println(followUp("aaabbbccbcbccbba", 2));
    }
}
