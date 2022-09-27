package company.deshaw;

public class Q1537 {
    public int maxSum(int[] nums1, int[] nums2) {
        int i = 0, j = 0, m = nums1.length, n = nums2.length;
        long best1 = 0, best2 = 0;
        while (i < m || j < n) {
            if (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    best1 += nums1[i++];
                } else if (nums1[i] > nums2[j]) {
                    best2 += nums2[j++];
                } else {
                    long best = Math.max(best1, best2) + nums1[i];
                    best1 = best2 = best;
                    i++;
                    j++;
                }
            } else if (i < m) {
                best1 += nums1[i++];
            } else {
                best2 += nums2[j++];
            }
        }
        return (int) (Math.max(best1, best2) % 1000000007);
    }
}
