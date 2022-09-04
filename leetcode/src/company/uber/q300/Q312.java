package company.uber.q300;

public class Q312 {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        arr[0] = 1;
        arr[arr.length - 1] = 1;
        System.arraycopy(nums, 0, arr, 1, nums.length);
        int[][] dp = new int[arr.length][arr.length];
        return helper(dp, arr, 0, arr.length - 1);
    }

    private int helper(int[][] dp, int[] nums, int left, int right) {
        if (left > right) return 0;
        if (dp[left][right] != 0) return dp[left][right];
        int res = 0;
        for (int i = left + 1; i < right; i++) {
            res = Math.max(res, nums[left] * nums[i] * nums[right] + helper(dp, nums, left, i)
                    + helper(dp, nums, i, right));
        }
        dp[left][right] = res;
        return res;
    }
}
