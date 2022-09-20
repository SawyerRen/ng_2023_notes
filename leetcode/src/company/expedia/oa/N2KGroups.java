package company.expedia.oa;

public class N2KGroups {
    public static int nToKGroups(int n, int k) {
        if(n < k) {
            return 0;
        }
        int[][] dp = new int[k+1][n+1];
        for(int i = 1; i <= k; i++) {
            for(int j = i; j <= n; j++) {
                if(i==j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-i];
                }
            }
        }
        return dp[k][n];
    }
}
