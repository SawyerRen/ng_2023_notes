package company.uber.q1200;

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
            int nextJobIndex = getNext(time, end, i, time.length - 1);
            if (nextJobIndex == -1) {
                dp[i] = Math.max(dp[i + 1], time[i][2]);
            } else {
                dp[i] = Math.max(dp[i + 1], dp[nextJobIndex] + time[i][2]);
            }
        }
        return dp[0];
    }

    private int getNext(int[][] time, int end, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (time[mid][0] >= end) right = mid;
            else left = mid + 1;
        }
        return left == time.length || time[left][0] < end ? -1 : left;
    }
}
