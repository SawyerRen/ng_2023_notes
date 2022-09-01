package company.bloomberg.q300;

import java.util.Stack;

public class Q394 {
    public String decodeString(String s) {
        Stack<StringBuilder> builderStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                count = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    count = count * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
            } else if (c == '[') {
                builderStack.push(builder);
                countStack.push(count);
                builder = new StringBuilder();
                count = 0;
            } else if (c == ']') {
                count = countStack.pop();
                StringBuilder pre = builderStack.pop();
                for (int j = 0; j < count; j++) {
                    pre.append(builder);
                }
                builder = pre;
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
