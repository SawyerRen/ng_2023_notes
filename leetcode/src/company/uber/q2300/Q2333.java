package company.uber.q2300;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q2333 {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] diff = new int[100001];
        long k = k1 + k2;
        long totalDiff = 0;
        int maxDiff = 0;
        for (int i = 0; i < nums1.length; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            if (d > 0) {
                totalDiff += d;
                maxDiff = Math.max(maxDiff, d);
                diff[d]++;
            }
        }
        if (totalDiff <= k) return 0;
        for (int i = maxDiff; i > 0 && k > 0; i--) {
            if (diff[i] > 0) {
                if (diff[i] >= k) {
                    diff[i] -= k;
                    diff[i - 1] += k;
                    k = 0;
                } else {
                    diff[i - 1] += diff[i];
                    k -= diff[i];
                    diff[i] = 0;
                }
            }
        }
        long res = 0;
        for (int i = 0; i <= maxDiff; i++) {
            if (diff[i] > 0) {
                res += (long) Math.pow((long) i, 2) * diff[i];
            }
        }
        return res;
    }
}
