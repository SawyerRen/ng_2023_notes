package company.uber.all1;

public class Q1423 {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] preSum = new int[n + 1];
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += cardPoints[i];
            preSum[i + 1] = preSum[i] + cardPoints[i];
        }
        k = n - k;
        int left = 0, right = k;
        int res = 0;
        while (right < n + 1) {
            res = Math.max(res, total - (preSum[right] - preSum[left]));
            left++;
            right++;
        }
        return res;
    }
}
