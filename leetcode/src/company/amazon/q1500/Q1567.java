package company.amazon.q1500;

public class Q1567 {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int[] positive = new int[n];
        int[] negative = new int[n];
        positive[0] = nums[0] > 0 ? 1 : 0;
        negative[0] = nums[0] < 0 ? 1 : 0;
        int res = positive[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                positive[i] = 0;
                negative[i] = 0;
            } else if (nums[i] < 0) {
                positive[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
                negative[i] = positive[i - 1] > 0 ? positive[i - 1] + 1 : 1;
            } else {
                positive[i] = positive[i - 1] + 1;
                negative[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
            }
            res = Math.max(res, positive[i]);
        }
        return res;
    }
}
