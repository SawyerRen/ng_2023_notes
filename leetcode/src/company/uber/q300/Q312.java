package company.uber.q300;

public class Q312 {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] temp = new int[n];
        temp[0] = temp[n - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            temp[i + 1] = nums[i];
        }
        int[][] memo = new int[n][n];
        return helper(memo, temp, 0, n - 1);
    }

    private int helper(int[][] memo, int[] nums, int left, int right) {
        if (left > right) return 0;
        if (memo[left][right] != 0) return memo[left][right];
        int res = 0;
        for (int i = left + 1; i < right; i++) {
            res = Math.max(res, helper(memo, nums, left, i) + helper(memo, nums, i, right)
                    + nums[left] * nums[i] * nums[right]);
        }
        memo[left][right] = res;
        return res;
    }
}
