package company.bloomberg.mj.tag;

public class Q2303 {
    public double calculateTax(int[][] brackets, int income) {
        double res = 0;
        for (int i = 0; i < brackets.length; i++) {
            int amount = i == 0 ? brackets[0][0] : brackets[i][0] - brackets[i - 1][0];
            if (amount > income) {
                res += income * (brackets[i][1] / 100.0);
                income = 0;
            } else {
                res += (brackets[i][1] / 100.0) * amount;
                income -= amount;
            }
            if (income == 0) break;
        }
        return res;
    }
}
