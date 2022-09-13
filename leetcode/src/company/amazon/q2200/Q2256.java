package company.amazon.q2200;

public class Q2256 {
    public int minimumAverageDifference(int[] nums) {
        long min = Integer.MAX_VALUE, res = -1;
        long[] preSum = new long[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum[i] = sum;
        }
        for (int i = 0; i < nums.length; i++) {
            long left = preSum[i] / (i + 1);
            long right = 0;
            if (i == nums.length - 1) right = 0;
            else right =
                    (preSum[nums.length - 1] - preSum[i]) / (nums.length - 1 - i);
            if (min > Math.abs(left - right)) {
                res = i;
                min = Math.abs(left - right);
            }
        }
        return (int) res;
    }
}
