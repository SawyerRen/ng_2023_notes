package company.bloomberg.q300;

import java.util.Stack;

public class Q394 {
    public String decodeString(String s) {
        Stack<StringBuilder> builderStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int count = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    count = count * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                countStack.push(count);
            } else if (c == '[') {
                builderStack.push(builder);
                builder = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = builderStack.pop();
                int count = countStack.pop();
                for (int k = 0; k < count; k++) {
                    temp.append(builder);
                }
                builder = temp;
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
