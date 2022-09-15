package company.amazon.finalround;

public class Q12 {
    String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public String intToRoman(int num) {
        int index = 0;
        StringBuilder builder = new StringBuilder();
        while (num != 0) {
            while (num >= values[index]) {
                builder.append(strs[index]);
                num -= values[index];
            }
            index++;
        }
        return builder.toString();
    }
}
