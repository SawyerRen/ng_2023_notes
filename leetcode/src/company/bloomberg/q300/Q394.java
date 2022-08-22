package company.bloomberg.q300;

import java.util.Stack;

public class Q394 {
    public String decodeString(String s) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> builderStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                count = c - '0';
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
                count = countStack.pop();
                for (int j = 0; j < count; j++) {
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
