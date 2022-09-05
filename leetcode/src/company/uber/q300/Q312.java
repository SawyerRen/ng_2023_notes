package company.uber.q300;

public class Q312 {
    public int maxCoins(int[] nums) {
        int[] temp = new int[nums.length + 2];
        System.arraycopy(nums, 0, temp, 1, nums.length);
        temp[0] = temp[temp.length - 1] = 1;
        int[][] memo = new int[temp.length][temp.length];
        return helper(memo, temp, 0, temp.length - 1);
    }

    private int helper(int[][] memo, int[] nums, int left, int right) {
        if (left > right) return 0;
        if (memo[left][right] != 0) return memo[left][right];
        int res = 0;
        for (int i = left + 1; i < right; i++) {
            res = Math.max(res, helper(memo, nums, left, i) + helper(memo, nums, i, right) +
                    nums[left] * nums[i] * nums[right]);
        }
        memo[left][right] = res;
        return res;
    }
}
