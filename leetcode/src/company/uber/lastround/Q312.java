package company.uber.lastround;

public class Q312 {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        System.arraycopy(nums, 0, arr, 1, nums.length);
        arr[0] = arr[arr.length - 1] = 1;
        int[][] memo = new int[arr.length][arr.length];
        return helper(memo, arr, 0, arr.length - 1);
    }

    private int helper(int[][] memo, int[] arr, int left, int right) {
        if (left > right) return 0;
        if (memo[left][right] != 0) return memo[left][right];
        int res = 0;
        for (int i = left + 1; i < right; i++) {
            res = Math.max(res, helper(memo, arr, left, i) + helper(memo, arr, i, right)
                    + arr[left] * arr[i] * arr[right]);
        }
        memo[left][right] = res;
        return res;
    }
}
