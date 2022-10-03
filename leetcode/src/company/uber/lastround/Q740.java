package company.uber.lastround;

public class Q740 {
    public int deleteAndEarn(int[] nums) {
        int[] sums = new int[10001];
        for (int num : nums) {
            sums[num] += num;
        }
        int[] dp = new int[10002];
        dp[10000] = sums[10000];
        for (int i = 9999; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + sums[i]);
        }
        return dp[0];
    }
}
