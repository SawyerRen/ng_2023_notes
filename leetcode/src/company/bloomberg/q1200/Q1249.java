package company.bloomberg.q1200;

import java.util.Stack;

public class Q1249 {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        boolean[] valid = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')' && !stack.isEmpty()) {
                valid[i] = true;
                valid[stack.pop()] = true;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                if (valid[i]) builder.append(c);
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public String minRemoveToMakeValid1(String s) {
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
}
