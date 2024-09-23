package company.bloomberg.goodluck;

import java.time.OffsetDateTime;
import java.util.Stack;

// 这道题两种解法，两个时间复杂度都是n，但是第一种的空间是1，第二种空间是n
public class Q1249 {
    // 解法1 
    public String minRemoveToMakeValid(String s) {
        // 数右括号的数量
        int right = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') right++;
        }
        int left = 0;
        StringBuilder builder = new StringBuilder();
        // 遍历s
        for (char c : s.toCharArray()) {
            // 遇到左括号，
            if (c == '(') {
                // 如果右边还有右括号，把这个左括号加入builder，同时可用的右括号的数量-1
                if (right > 0) {
                    builder.append(c);
                    right--;
                }
                left++; // 左括号的数量+1
            } else if (c == ')') { // 遇到右括号
                // 如果左括号的数量>0,说明左边有一个开的左括号，把右括号加入builder，同时左括号的数量-1
                if (left > 0) {
                    builder.append(c);
                    left--;
                // 否则的话，这个右括号被跳过，能用的右括号数量-1,
                // 为什么上面的右括号没有-1？因为这个右括号已经在上面的左括号的时候已经-1了
                } else {
                    right--;
                }
            } else {
                // 不是括号 直接加入
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public String minRemoveToMakeValid1(String s) {
        int n = s.length();
        Set<Integer> invalidIndexSet = new HashSet<>(); // 这个set中保存需要去掉的index
        Stack<Integer> stack = new Stack<>(); // 用来匹配括号
        for (int i = 0; i < s.length(); i++) {
            // 左括号推入栈中
            if (s.charAt(i) == '(') {
                stack.push(i);
            // 右括号时，如果栈中有左括号，弹出左括号，否则这个右括号就是invalid的，加入set中
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    invalidIndexSet.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        // 剩余在栈中的就是匹配不到右括号的invalid的左括号
        while (!stack.isEmpty()) {
            invalidIndexSet.add(stack.pop());
        }
        StringBuilder builder = new StringBuilder();
        // 只要不是在set中的，都是valid的
        for (int i = 0; i < s.length(); i++) {
            if (!invalidIndexSet.contains(i)) {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }
}
