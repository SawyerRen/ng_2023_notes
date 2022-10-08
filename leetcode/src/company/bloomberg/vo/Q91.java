package company.bloomberg.vo;

public class Q91 {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < n + 1; i++) {
            int pre1 = Integer.parseInt(s.substring(i - 1, i));
            if (pre1 != 0) dp[i] += dp[i - 1];
            int pre2 = Integer.parseInt(s.substring(i - 2, i));
            if (pre2 >= 10 && pre2 <= 26) dp[i] += dp[i - 2];
        }
        return dp[n];
    }
}
