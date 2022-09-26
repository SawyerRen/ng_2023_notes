package company.uber.all1;

public class Q121 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = prices[0];
        for (int price : prices) {
            min = Math.min(min, price);
            res = Math.max(res, price - min);
        }
        return res;
    }
}
