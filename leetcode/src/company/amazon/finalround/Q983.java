package company.amazon.finalround;

import java.lang.annotation.Target;

public class Q983 {
    public int mincostTickets(int[] days, int[] costs) {
        int maxDay = days[days.length - 1];
        int[] dp = new int[maxDay + 1];
        boolean[] travel = new boolean[maxDay + 1];
        for (int day : days) {
            travel[day] = true;
        }
        for (int i = 1; i < maxDay + 1; i++) {
            if (!travel[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = dp[i - 1] + costs[0];
            if (i >= 7) {
                dp[i] = Math.min(dp[i], dp[i - 7] + costs[1]);
            } else {
                dp[i] = Math.min(dp[i], dp[0] + costs[1]);
            }
            if (i >= 30) {
                dp[i] = Math.min(dp[i], dp[i - 30] + costs[2]);
            } else {
                dp[i] = Math.min(dp[i], dp[0] + costs[2]);
            }
        }
        return dp[maxDay];
    }
}
