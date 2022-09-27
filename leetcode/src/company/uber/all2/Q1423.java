package company.uber.all2;

public class Q1423 {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] preSum = new int[n + 1];
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += cardPoints[i];
            preSum[i + 1] = preSum[i] + cardPoints[i];
        }
        int res = 0;
        int left = 0, right = n - k;
        while (right < preSum.length) {
            res = Math.max(res, total - (preSum[right] - preSum[left]));
            left++;
            right++;
        }
        return res;
    }
}
