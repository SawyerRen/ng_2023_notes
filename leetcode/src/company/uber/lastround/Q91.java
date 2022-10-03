package company.uber.lastround;

public class Q91 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < dp.length; i++) {
            int pre1 = s.charAt(i - 1) - '0';
            if (pre1 != 0) dp[i] += dp[i - 1];
            int pre2 = Integer.parseInt(s.substring(i - 2, i));
            if (pre2 >= 10 && pre2 <= 26) dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }
}
