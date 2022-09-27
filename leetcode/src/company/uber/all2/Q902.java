package company.uber.all2;

public class Q902 {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int res = 0;
        String s = String.valueOf(n);
        for (int i = 1; i < s.length(); i++) {
            res += Math.pow(digits.length, i);
        }
        for (int i = 0; i < s.length(); i++) {
            boolean sameStart = false;
            for (String d : digits) {
                if (s.charAt(i) - '0' > Integer.parseInt(d)) {
                    res += Math.pow(digits.length, s.length() - 1 - i);
                } else if (s.charAt(i) - '0' == Integer.parseInt(d)) {
                    sameStart = true;
                }
            }
            if (!sameStart) return res;
        }
        return res + 1;
    }
}
