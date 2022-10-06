package company.bloomberg.all.q0;

public class Q53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int res = nums[0];
        int curMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            res = Math.max(res, curMax);
        }
        return res;
    }

    public int maxSubArray1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
