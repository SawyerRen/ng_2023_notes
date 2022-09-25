package company.uber.all1;

public class Q312 {
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        System.arraycopy(nums, 0, newNums, 1, nums.length);
        newNums[0] = newNums[newNums.length - 1] = 1;
        int[][] memo = new int[newNums.length][newNums.length];
        return helper(memo, newNums, 0, newNums.length - 1);
    }

    private int helper(int[][] memo, int[] nums, int left, int right) {
        if (left > right) return 0;
        if (memo[left][right] != 0) return memo[left][right];
        int res = 0;
        for (int i = left + 1; i < right; i++) {
            res = Math.max(res, nums[left] * nums[i] * nums[right] + helper(memo, nums, left, i) + helper(memo, nums, i, right));
        }
        memo[left][right] = res;
        return res;
    }
}
