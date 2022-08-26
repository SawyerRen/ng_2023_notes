package company.amazon.q1800;

public class Q1864 {
    public int minSwaps(String s) {
        int n = s.length();
        int count1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') count1++;
        }
        if (count1 * 2 > n + 1 || count1 * 2 < n - 1) return -1;
        if (n % 2 == 1) {
            if (count1 * 2 == n - 1) return getMinSwap('0', n, s);
            else return getMinSwap('1', n, s);
        } else {
            return Math.min(getMinSwap('0', n, s), getMinSwap('1', n, s));
        }
    }

    private int getMinSwap(char curNum, int n, String s) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != curNum) count++;
            curNum = curNum == '1' ? '0' : '1';
        }
        return count / 2;
    }
}
