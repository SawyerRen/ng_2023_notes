package company.uber.q1200;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Q1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] time = new int[n][3];
        for (int i = 0; i < n; i++) {
            time[i][0] = startTime[i];
            time[i][1] = endTime[i];
            time[i][2] = profit[i];
        }
        Arrays.sort(time, (a, b) -> a[0] - b[0]);
        int[] dp = new int[n];
        dp[n - 1] = time[n - 1][2];
        for (int i = n - 2; i >= 0; i--) {
            int end = time[i][1];
            int nextJobIndex = search(time, end, i);
            if (nextJobIndex == -1) {
                dp[i] = Math.max(dp[i + 1], time[i][2]);
            } else {
                dp[i] = Math.max(dp[i + 1], time[i][2] + dp[nextJobIndex]);
            }
        }
        return dp[0];
    }

    private int search(int[][] time, int end, int start) {
        int left = start + 1, right = time.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (time[mid][0] >= end) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left == time.length || time[left][0] < end) return -1;
        return left;
    }
}
