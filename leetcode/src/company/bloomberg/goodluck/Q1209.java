package company.bloomberg.goodluck;

import java.util.LinkedList;

public class Q1209 {
    class Node {
        char ch; // char
        int count; // 出现的次数

        public Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {
        LinkedList<Node> stack = new LinkedList<>();
        // 遍历s
        for (char c : s.toCharArray()) {
            // 如果stack不为空，并且当前字符和之前的字符相同，之前的字符出现的次数++，如果出现的次数到达k，从stack中去掉
            if (!stack.isEmpty() && c == stack.peekLast().ch) {
                stack.peekLast().count++;
                if (stack.peekLast().count == k) {
                    stack.removeLast();
                }
            // 否则，加入新的Node，char，出现的次数是1
            } else {
                stack.addLast(new Node(c, 1));
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            Node node = stack.removeFirst(); // 注意要按顺序，所以先removefirst
            for (int i = 0; i < node.count; i++) {
                builder.append(node.ch);
            }
        }
        return builder.toString();
    }

    // BBG一般会问下面这个问题，1D的candy crush，这题跟上面那题的区别是：
    // 上面那道题一遇到k个重复的就删除，比如k = 3， s = "aaaa", 最后会剩下"a"，因为前三个a被移除了
    // 这道题则是移除所有重复的，比如k = 3, s = "aaaa", 最后返回 "",空字符串
    // 需要做的改变是，在遇到和之前不同的字符的时候，看前一个字符是不是要移除
    public String candyCrash(String s) {
        LinkedList<Node> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                // 如果遇到了新的字符，并且前面的字符出现次数>=3，移除前面的字符
                if (stack.peekLast().ch != c && stack.peekLast().count >= 3) {
                    stack.removeLast();
                }
                // 否则，要么count++，要么新建一个Node，和上面一样
                if (!stack.isEmpty() && stack.peekLast().ch == c) {
                    stack.peekLast().count++;
                } else {
                    stack.addLast(new Node(c, 1));
                }
            } else {
                stack.addLast(new Node(c, 1));
            }
        }
        // 最后需要判断一下最后的Node，因为我们每次是去检查前一个，这样我们在循环中检查不了最后一个，需要在这边检查
        if (!stack.isEmpty() && stack.peekLast().count >= 3) {
            stack.removeLast();
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

    public String candyCrashFollowUp(String s) {
        return helper(s, 0);
    }

    private String helper(String s, int index) {
        while (index < s.length() - 2) {
            if (s.charAt(index) == s.charAt(index + 1) && s.charAt(index + 1) == s.charAt(index + 2)) {
                int left = index;
                int right = index + 2;
                while (right < s.length() && s.charAt(right) == s.charAt(left)) right++;
                String crash = helper(s.substring(0, left) + s.substring(right), 0);
                String notCrash = helper(s, right);
                if (crash.length() < notCrash.length()) {
                    return crash;
                } else {
                    return notCrash;
                }
            }
            index++;
        }
        return s;
    }
}
