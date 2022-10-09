package company.bloomberg.mj.nontag;

import java.util.LinkedList;
import java.util.Stack;

public class CandyCrush1D {
    static class Node {
        char ch;
        int count;

        public Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public static String candyCrush1D(String s) {
        LinkedList<Node> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (c != stack.peekLast().ch && stack.peekLast().count >= 3) {
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
        for (Node node : stack) {
            for (int i = 0; i < node.count; i++) {
                builder.append(node.ch);
            }
        }
        return builder.toString();
    }

    static String followUp(String s) {
        return helper(s, 0);
    }

    private static String helper(String s, int index) {
        while (index < s.length() - 2) {
            if (s.charAt(index) == s.charAt(index + 1) && s.charAt(index + 1) == s.charAt(index + 2)) {
                int left = index, right = index + 2;
                while (right < s.length() && s.charAt(right) == s.charAt(left)) {
                    right++;
                }
                String crash = helper(s.substring(0, left) + s.substring(right), 0);
                String notCrash = helper(s, right);
                if (crash.length() < notCrash.length()) return crash;
                else return notCrash;
            }
            index++;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(candyCrush1D("aaabbbc"));
        System.out.println(candyCrush1D("aabbbacd"));
        System.out.println(candyCrush1D("aabbccddeeedcba"));
        System.out.println(candyCrush1D("aaabbbacd"));
        System.out.println(followUp("aaabbbacd"));
    }
}
