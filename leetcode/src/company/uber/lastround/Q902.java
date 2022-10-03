package company.uber.lastround;

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
                if (Integer.parseInt(d) < s.charAt(i) - '0') {
                    res += Math.pow(digits.length, s.length() - 1 - i);
                } else if (Integer.parseInt(d) == s.charAt(i) - '0') {
                    sameStart = true;
                }
            }
            if (!sameStart) return res;
        }
        return res + 1;
    }
}
