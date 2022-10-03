package company.uber.lastround;

import java.util.Arrays;

public class Q1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        int n = startTime.length;
        int[] dp = new int[n];
        dp[n - 1] = jobs[n - 1][2];
        for (int i = n - 2; i >= 0; i--) {
            int nextJobIndex = search(jobs, jobs[i][1], i + 1, n);
            if (nextJobIndex == -1) {
                dp[i] = Math.max(dp[i + 1], jobs[i][2]);
            } else {
                dp[i] = Math.max(dp[nextJobIndex] + jobs[i][2], dp[i + 1]);
            }
        }
        return dp[0];
    }

    private int search(int[][] jobs, int end, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][0] >= end) right = mid;
            else left = mid + 1;
        }
        if (left == jobs.length || jobs[left][0] < end) return -1;
        return left;
    }
}
