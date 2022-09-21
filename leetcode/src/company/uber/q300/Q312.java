package company.uber.q300;

public class Q312 {
    public int maxCoins(int[] nums) {
        int[] temp = new int[nums.length + 2];
        temp[0] = temp[temp.length - 1] = 1;
        System.arraycopy(nums, 0, temp, 1, nums.length);
        int[][] dp = new int[temp.length][temp.length];
        return helper(dp, temp, 0, temp.length - 1);
    }

    private int helper(int[][] dp, int[] balloons, int left, int right) {
        if (left > right) return 0;
        if (dp[left][right] != 0) return dp[left][right];
        int res = 0;
        for (int i = left + 1; i < right; i++) {
            res = Math.max(res, helper(dp, balloons, left, i) + helper(dp, balloons, i, right)
                    + balloons[left] * balloons[right] * balloons[i]);
        }
        dp[left][right] = res;
        return res;
    }
}
