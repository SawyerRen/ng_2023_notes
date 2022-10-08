package company.bloomberg.vo;

public class Q213 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n1 = helper(nums, 0, nums.length - 2);
        int n2 = helper(nums, 1, nums.length - 1);
        return Math.max(n1, n2);
    }

    private int helper(int[] nums, int start, int end) {
        int[] dp = new int[nums.length + 1];
        dp[end] = nums[end];
        dp[end + 1] = 0;
        for (int i = end - 1; i >= start; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[start];
    }
}
