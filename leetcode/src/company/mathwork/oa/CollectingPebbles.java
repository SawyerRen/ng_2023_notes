package company.mathwork.oa;

import java.util.Arrays;

public class CollectingPebbles {
    int getBuckets(int numOfPebbles, int[] bucketSizes) {
        int[] dp = new int[numOfPebbles + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < numOfPebbles + 1; i++) {
            for (int size : bucketSizes) {
                if (i >= size && dp[i - size] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - size] + 1);
                }
            }
        }
        return dp[numOfPebbles];
    }
}
