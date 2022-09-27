package company.deshaw;

public class CountIntegerPartitions {
    static int solution(int n) {
        int[] memo = new int[n + 1];
        return helper(memo, 0, n);
    }

    private static int helper(int[] memo, int cur, int n) {
        if (cur > n) return 0;
        if (cur == n) return 1;
        if (memo[cur] != 0) return memo[cur];
        int res = 0;
        for (int i = 1; i < n; i++) {
            res += helper(memo, cur + i, n);
        }
        memo[cur] = res;
        return res;
    }

    static int solution1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int num = 1; num < n; num++) {
            for (int j = 1; j < n + 1; j++) {
                if (j >= num) dp[j] += dp[j - num];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(5));
    }
}
