package company.bloomberg.goodluck;

import java.util.LinkedList;

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
            if (!stack.isEmpty() && c == stack.peekLast().ch) {
                stack.peekLast().count++;
                if (stack.peekLast().count == k) {
                    stack.removeLast();
                }
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

    public String candyCrash(String s) {
        LinkedList<Node> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (stack.peekLast().ch != c && stack.peekLast().count >= 3) {
                    stack.removeLast();
                }
                if (!stack.isEmpty() && stack.peekLast().ch == c) {
                    stack.peekLast().count++;
                } else {
                    stack.addLast(new Node(c, 1));
                }
            } else {
                stack.addLast(new Node(c, 1));
            }
        }
        if (!stack.isEmpty() && stack.peekLast().count >= 3) {
            stack.removeLast();
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

    public String candyCrashFollowUp(String s) {
        return helper(s, 0);
    }

    private String helper(String s, int index) {
        while (index < s.length() - 2) {
            if (s.charAt(index) == s.charAt(index + 1) && s.charAt(index + 1) == s.charAt(index + 2)) {
                int left = index;
                int right = index + 2;
                while (right < s.length() && s.charAt(right) == s.charAt(left)) right++;
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
