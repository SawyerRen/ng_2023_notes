package company.amazon.q0;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void helper(List<String> res, StringBuilder builder, int left, int right, int n) {
        if (left == n && right == n) {
            res.add(builder.toString());
            return;
        }
        if (left < n) {
            builder.append("(");
            helper(res, builder, left + 1, right, n);
            builder.setLength(builder.length() - 1);
        }
        if (right < left) {
            builder.append(")");
            helper(res, builder, left, right + 1, n);
            builder.setLength(builder.length() - 1);
        }
    }

    static char[] chars = {'(', ')', '{', '}', '[', ']'};

    static List<String> followUp(int n) {
        Set<String> res = new HashSet<>();
        helper1(res, new StringBuilder(), new int[6], n);
        return new ArrayList<>(res);
    }

    private static void helper1(Set<String> res, StringBuilder builder, int[] count, int n) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] > n) return;
            if (i % 2 == 0 && count[i] < count[i + 1]) return;
        }
        if (valid(count, n)) {
            res.add(builder.toString());
            return;
        }
        for (int i = 0; i < 6; i++) {
            builder.append(chars[i]);
            count[i]++;
            helper1(res, builder, count, n);
            count[i]--;
            builder.setLength(builder.length() - 1);
        }
    }

    private static boolean valid(int[] count, int n) {
        for (int i : count) {
            if (i != n) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(followUp(1));
    }
}
