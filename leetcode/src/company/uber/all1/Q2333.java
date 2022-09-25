package company.uber.all1;

public class Q2333 {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] diffs = new int[100001];
        long totalDiff = 0;
        int maxDiff = 0;
        int k = k1 + k2;
        for (int i = 0; i < nums1.length; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            totalDiff += d;
            maxDiff = Math.max(maxDiff, d);
            diffs[d]++;
        }
        if (totalDiff <= k) return 0;
        for (int i = maxDiff; i > 0; i--) {
            if (k == 0) break;
            if (diffs[i] > k) {
                diffs[i] -= k;
                diffs[i - 1] += k;
                k = 0;
            } else {
                diffs[i - 1] += diffs[i];
                k -= diffs[i];
                diffs[i] = 0;
            }
        }
        long res = 0;
        for (int i = maxDiff; i > 0; i--) {
            res += Math.pow(i, 2) * diffs[i];
        }
        return res;
    }
}
