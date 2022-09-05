package company.uber.q700;

public class Q740 {
    public int deleteAndEarn(int[] nums) {
        int[] sum = new int[10001];
        for (int num : nums) {
            sum[num] += num;
        }
        int[] dp = new int[10002];
        dp[10001] = 0;
        dp[10000] = sum[10000];
        for (int i = 9999; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], sum[i] + dp[i + 2]);
        }
        return dp[0];
    }
}
