package company.bloomberg.goodluck;

import java.util.Stack;

public class Q394 {
    public String decodeString(String s) {
        StringBuilder builder = new StringBuilder(); // 保存当前的字符串
        int count = 0; 
        Stack<StringBuilder> builderStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果是数字，更新count
            if (Character.isDigit(c)) {
                count = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    count = count * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                // 如果遇到左括号，将builder和count存入stack中，重置builder和count
            } else if (c == '[') {
                builderStack.push(builder);
                countStack.push(count);
                builder = new StringBuilder();
                count = 0;
                // 如果遇到右括号，取出之前的builder和count，新的builder = 之前的builder + builder *count
                // 比如说，a2[b] = a + 2 * b = abb
            } else if (c == ']') {
                StringBuilder pre = builderStack.pop();
                int temp = countStack.pop();
                for (int j = 0; j < temp; j++) {
                    pre.append(builder);
                }
                builder = pre;
                // 不是数字或者括号，直接加入builder
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
