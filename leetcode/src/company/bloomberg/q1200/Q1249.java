package company.bloomberg.q1200;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Q1249 {
    public String minRemoveToMakeValid(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') right++;
        }
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (right > 0) {
                    builder.append(c);
                    right--;
                }
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    builder.append(c);
                    left--;
                } else {
                    right--;
                }
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public String minRemoveToMakeValid1(String s) {
        Set<Integer> validIndex = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    validIndex.add(stack.pop());
                    validIndex.add(i);
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '(' && c != ')') builder.append(c);
            else if (validIndex.contains(i)) builder.append(c);
        }
        return builder.toString();
    }
}
