package company.amazon.q1800;

public class Q1864 {
    public int minSwaps(String s) {
        int count0 = 0, count1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') count1++;
            else count0++;
        }
        if (count1 > count0 + 1 || count0 > count1 + 1) return -1;
        if (count1 > count0) {
            return helper(s, '1');
        } else if (count1 < count0) {
            return helper(s, '0');
        } else {
            return Math.min(helper(s, '0'), helper(s, '1'));
        }
    }

    private int helper(String s, char cur) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c != cur) count++;
            cur = cur == '1' ? '0' : '1';
        }
        return count / 2;
    }
}
