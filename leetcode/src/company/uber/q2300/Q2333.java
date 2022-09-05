package company.uber.q2300;

public class Q2333 {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] diff = new int[100001];
        long k = k1 + k2;
        int maxDiff = 0;
        long totalDiff = 0;
        for (int i = 0; i < nums1.length; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(d, maxDiff);
            totalDiff += d;
            diff[d]++;
        }
        if (totalDiff <= k) return 0;
        for (int i = maxDiff; i > 0; i--) {
            if (k == 0) break;
            if (diff[i] > 0) {
                if (k > diff[i]) {
                    diff[i - 1] += diff[i];
                    k -= diff[i];
                    diff[i] = 0;
                } else {
                    diff[i] -= k;
                    diff[i - 1] += k;
                    k = 0;
                }
            }
        }
        long res = 0;
        for (int i = maxDiff; i > 0; i--) {
            if (diff[i] > 0) {
                res += Math.pow(i, 2) * diff[i];
            }
        }
        return res;
    }
}
