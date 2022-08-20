package company.amazon.q0;

public class Q12 {
    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                builder.append(symbols[i]);
                num -= values[i];
                if (num == 0) return builder.toString();
            }
        }
        return builder.toString();
    }
}
