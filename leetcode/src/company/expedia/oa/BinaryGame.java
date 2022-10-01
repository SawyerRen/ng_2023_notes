package company.expedia.oa;

public class BinaryGame {
    static int solution(int minLen, int maxLen, int oneGroup, int zeroGroup) {
        int[] dp = new int[maxLen + 1];
        dp[0] = 1;
        int mod = 1000000007;
        int res = 0;
        for (int i = 1; i < maxLen + 1; i++) {
            if (i >= oneGroup) dp[i] = (dp[i] + dp[i - oneGroup]) % mod;
            if (i >= zeroGroup) dp[i] = (dp[i] + dp[i - zeroGroup]) % mod;
            if (i >= minLen) res = (res + dp[i]) % mod;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 3, 2, 1));
    }
}
