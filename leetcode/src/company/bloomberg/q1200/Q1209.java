package company.bloomberg.q1200;

import javax.sound.midi.Soundbank;
import java.util.*;

public class Q1209 {
    static class Node {
        char ch;
        int count;

        public Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {
        Deque<Node> stack = new LinkedList<>();
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

    static String followUp(String s) {
        Deque<Node> stack = new LinkedList<>();
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
        if (!stack.isEmpty() && stack.getLast().count >= 3) stack.removeLast();
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            Node node = stack.removeFirst();
            for (int i = 0; i < node.count; i++) {
                builder.append(node.ch);
            }
        }
        return builder.toString();
    }

    static String recursionFindBest(String s) {
        return recursion(s, 0);
    }

    static String recursionFindBestWithMemo(String s) {
        return recursionWithMemo(s, 0);
    }

    private static String recursion(String s, int i) {
        while (i < s.length()) {
            if (i + 2 < s.length() && s.charAt(i) == s.charAt(i + 1) && s.charAt(i + 1) == s.charAt(i + 2)) {
                int j = i;
                i += 2;
                char repeatChar = s.charAt(i);
                while (i < s.length() && s.charAt(i) == repeatChar) i++;
                String next = s.substring(0, j) + s.substring(i);
                String unCrush = recursion(s, i);
                String crush = recursion(next, 0);
                if (unCrush.length() < crush.length()) return unCrush;
                else return crush;
            }
            i++;
        }
        return s;
    }

    static Map<String, String> memo = new HashMap<>();

    private static String recursionWithMemo(String s, int i) {
        if (memo.containsKey(s)) return memo.get(s);
        while (i < s.length()) {
            if (i + 2 < s.length() && s.charAt(i) == s.charAt(i + 1) && s.charAt(i + 1) == s.charAt(i + 2)) {
                int j = i;
                i += 2;
                char repeatChar = s.charAt(i);
                while (i < s.length() && s.charAt(i) == repeatChar) i++;
                String next = s.substring(0, j) + s.substring(i);
                String unCrush = recursionWithMemo(s, i);
                String crush = recursionWithMemo(next, 0);
                if (unCrush.length() < crush.length()) {
                    memo.put(s, unCrush);
                    return unCrush;
                } else {
                    memo.put(s, crush);
                    return crush;
                }
            }
            i++;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(followUp("aaabbbc"));
        System.out.println(followUp("aabbbacd"));
        System.out.println(followUp("aabbccddeeedcba"));
        System.out.println(followUp("aaabbbacd"));
        System.out.println(recursionFindBest("aaabbbacd"));
        System.out.println(recursionFindBestWithMemo("aaabbbacd"));
    }
}
