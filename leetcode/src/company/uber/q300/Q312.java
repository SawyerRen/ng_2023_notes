package company.uber.q300;

public class Q312 {
    public int maxCoins(int[] nums) {
        int[] balloons = new int[nums.length + 2];
        System.arraycopy(nums, 0, balloons, 1, nums.length);
        balloons[0] = balloons[balloons.length - 1] = 1;
        int[][] dp = new int[balloons.length][balloons.length];
        return helper(dp, balloons, 0, balloons.length - 1);
    }

    private int helper(int[][] dp, int[] balloons, int left, int right) {
        if (left > right) return 0;
        if (dp[left][right] != 0) return dp[left][right];
        int res = 0;
        for (int i = left + 1; i < right; i++) {
            res = Math.max(res, helper(dp, balloons, left, i) + helper(dp, balloons, i, right)
                    + balloons[left] * balloons[i] * balloons[right]);
        }
        dp[left][right] = res;
        return res;
    }
}
