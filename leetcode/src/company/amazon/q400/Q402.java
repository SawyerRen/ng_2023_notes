package company.amazon.q400;

import java.util.LinkedList;

public class Q402 {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        LinkedList<Integer> list = new LinkedList<>();
        for (char c : num.toCharArray()) {
            while (!list.isEmpty() && k > 0 && c - '0' < list.getLast()) {
                list.removeLast();
                k--;
            }
            list.addLast(c - '0');
        }
        while (k > 0) {
            list.removeLast();
            k--;
        }
        StringBuilder builder = new StringBuilder();
        while (!list.isEmpty()) {
            builder.append(list.removeFirst());
        }
        while (builder.length() > 0 && builder.charAt(0) == '0') builder.deleteCharAt(0);
        if (builder.length() == 0) return "0";
        return builder.toString();
    }
}
