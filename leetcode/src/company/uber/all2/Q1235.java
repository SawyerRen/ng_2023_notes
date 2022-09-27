package company.uber.all2;

import java.util.Arrays;

public class Q1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        int[] dp = new int[n];
        dp[n - 1] = jobs[n - 1][2];
        for (int i = n - 2; i >= 0; i--) {
            int nextJobIndex = helper(jobs, i, n, jobs[i][1]);
            if (nextJobIndex == -1) {
                dp[i] = Math.max(dp[i + 1], jobs[i][2]);
            } else {
                dp[i] = Math.max(dp[i + 1], jobs[i][2] + dp[nextJobIndex]);
            }
        }
        return dp[0];
    }

    private int helper(int[][] jobs, int left, int right, int end) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][0] >= end) right = mid;
            else left = mid + 1;
        }
        if (left == jobs.length || jobs[left][0] < end) return -1;
        return left;
    }
}
