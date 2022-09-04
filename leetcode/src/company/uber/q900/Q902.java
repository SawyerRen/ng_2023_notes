package company.uber.q900;

public class Q902 {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String nStr = String.valueOf(n);
        int res = 0;
        for (int i = 1; i < nStr.length(); i++) {
            res += Math.pow(digits.length, i);
        }
        for (int i = 0; i < nStr.length(); i++) {
            boolean sameStart = false;
            for (String digit : digits) {
                if (nStr.charAt(i) - '0' > Integer.parseInt(digit)) {
                    res += Math.pow(digits.length, nStr.length() - i - 1);
                } else if (nStr.charAt(i) - '0' == Integer.parseInt(digit)) {
                    sameStart = true;
                }
            }
            if (!sameStart) return res;
        }
        return res + 1;
    }
}
