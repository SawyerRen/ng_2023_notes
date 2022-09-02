package company.bloomberg.q1200;

import java.util.*;

public class Q1209 {
    static class Node {
        int count;
        char ch;

        public Node(int count, char ch) {
            this.count = count;
            this.ch = ch;
        }
    }

    public static String candyCrush1D(String s) {
        LinkedList<Node> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (stack.peekLast().ch != c && stack.peekLast().count >= 3) {
                    stack.removeLast();
                }
                if (!stack.isEmpty() && stack.peekLast().ch == c) {
                    stack.peekLast().count++;
                } else {
                    stack.addLast(new Node(1, c));
                }
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

    public static void main(String[] args) {
        System.out.println(candyCrush1D("aaabbbc"));
        System.out.println(candyCrush1D("aabbbacd"));
        System.out.println(candyCrush1D("aabbccddeeedcba"));
        System.out.println(candyCrush1D("aaabbbacd"));
        System.out.println(recursionFindBest("aaabbbacd"));
//        System.out.println(recursionFindBestWithMemo("aaabbbacd"));
    }

    private static String recursionFindBest(String s) {
        return helper(s, 0);
    }

    static Map<String, String> memo = new HashMap<>();

    private static String helper(String s, int index) {
        if (memo.containsKey(s)) return memo.get(s);
        while (index < s.length() - 2) {
            if (s.charAt(index) == s.charAt(index + 1) && s.charAt(index + 1) == s.charAt(index + 2)) {
                int left = index;
                int right = index + 2;
                while (right < s.length() && s.charAt(right) == s.charAt(left)) right++;
                String sub = s.substring(0, left) + s.substring(right);
                String crash = helper(sub, 0);
                String notCrash = helper(s, right);
                if (crash.length() < notCrash.length()) {
                    memo.put(s, crash);
                    return crash;
                }
                else {
                    memo.put(s, notCrash);
                    return notCrash;
                }
            }
            index++;
        }
        memo.put(s, s);
        return s;
    }
}
