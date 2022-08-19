package company.uber.q300;

public class Q312 {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] temp = new int[n];
        System.arraycopy(nums, 0, temp, 1, n - 2);
        temp[0] = temp[n - 1] = 1;
        int[][] memo = new int[n][n];
        return helper(memo, temp, 0, n - 1);
    }

    private int helper(int[][] memo, int[] temp, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] != 0) return memo[left][right];
        int res = 0;
        for (int i = left + 1; i < right; i++) {
            res = Math.max(res, helper(memo, temp, left, i) + helper(memo, temp, i, right)
                    + temp[left] * temp[i] * temp[right]);
        }
        memo[left][right] = res;
        return res;
    }
}
