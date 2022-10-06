package company.bloomberg.all.q100;

public class Q121 {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int res = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            res = Math.max(res, price - minPrice);
        }
        return res;
    }
}
