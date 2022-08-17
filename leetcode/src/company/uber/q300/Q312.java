package company.uber.q300;

import java.util.Map;

public class Q312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] copy = new int[n + 2];
        System.arraycopy(nums, 0, copy, 1, n);
        copy[0] = copy[copy.length - 1] = 1;
        int[][] memo = new int[n + 2][n + 2];
        return helper(memo, copy, 0, copy.length - 1);
    }

    private int helper(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int res = 0;
        for (int i = left + 1; i < right; i++) {
            res = Math.max(res, helper(memo, nums, left, i) + nums[left] * nums[i] * nums[right]
                    + helper(memo, nums, i, right));
        }
        memo[left][right] = res;
        return res;
    }
}
