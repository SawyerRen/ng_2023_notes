package company.bloomberg.r2;

import java.util.LinkedList;
import java.util.Stack;

public class CandyCrash1D {
    class Node {
        char c;
        int count;

        public Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    String solution(String s) {
        LinkedList<Node> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (c != stack.peekLast().c && stack.peekLast().count >= 3) {
                    stack.removeLast();
                }
                if (!stack.isEmpty() && c == stack.peekLast().c) {
                    stack.peekLast().count++;
                } else {
                    stack.push(new Node(c, 1));
                }
            } else {
                stack.push(new Node(c, 1));
            }
        }
        if (!stack.isEmpty() && stack.peekLast().count >= 3) {
            stack.removeLast();
        }
        StringBuilder builder = new StringBuilder();
        for (Node node : stack) {
            for (int i = 0; i < node.count; i++) {
                builder.append(node.c);
            }
        }
        return builder.toString();
    }

    String followUp(String s) {
        return helper(s, 0);
    }

    private String helper(String s, int index) {
        while (index < s.length() - 2) {
            if (s.charAt(index) == s.charAt(index + 1) && s.charAt(index + 1) == s.charAt(index + 2)) {
                int left = index, right = index + 2;
                while (right < s.length() && s.charAt(right) == s.charAt(left)) {
                    right++;
                }
                String crash = helper(s.substring(0, left) + s.substring(right), 0);
                String notCrash = helper(s, right);
                if (crash.length() < notCrash.length()) {
                    return crash;
                } else {
                    return notCrash;
                }
            }
            index++;
        }
        return s;
    }
}
