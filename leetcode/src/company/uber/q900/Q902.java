package company.uber.q900;

public class Q902 {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String nStr = String.valueOf(n);
        int total = 0;
        for (int i = 1; i < nStr.length(); i++) {
            total += Math.pow(digits.length, i);
        }
        for (int i = 0; i < nStr.length(); i++) {
            boolean sameStart = false;
            for (String digit : digits) {
                int digitVal = Integer.parseInt(digit);
                if (digitVal < nStr.charAt(i) - '0') total += Math.pow(digits.length, nStr.length() - i - 1);
                else if (digitVal == nStr.charAt(i) - '0') sameStart = true;
            }
            if (!sameStart) return total;
        }
        return total + 1;
    }
}
