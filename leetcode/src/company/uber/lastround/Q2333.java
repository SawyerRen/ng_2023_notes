package company.uber.lastround;

public class Q2333 {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] diff = new int[100001];
        long totalDiff = 0;
        int maxDiff = 0;
        for (int i = 0; i < nums1.length; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            totalDiff += d;
            maxDiff = Math.max(maxDiff, d);
            diff[d]++;
        }
        int k = k1 + k2;
        if (totalDiff <= k) return 0;
        for (int i = maxDiff; i >= 0 && k > 0; i--) {
            if (diff[i] > k) {
                diff[i - 1] += k;
                diff[i] -= k;
                k = 0;
            } else {
                diff[i - 1] += diff[i];
                k -= diff[i];
                diff[i] = 0;
            }
        }
        long res = 0;
        for (int i = maxDiff; i > 0; i--) {
            res += Math.pow(i, 2) * diff[i];
        }
        return res;
    }
}
