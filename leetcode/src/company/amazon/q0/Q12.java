package company.amazon.q0;

public class Q12 {
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        int index = 0;
        while (num != 0) {
            while (num >= values[index]) {
                builder.append(symbols[index]);
                num -= values[index];
            }
            index++;
        }
        return builder.toString();
    }
}
