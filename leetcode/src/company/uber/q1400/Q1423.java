package company.uber.q1400;

public class Q1423 {
    public int maxScore(int[] cardPoints, int k) {
        int total = 0;
        int[] preSum = new int[cardPoints.length + 1];
        for (int i = 0; i < cardPoints.length; i++) {
            total += cardPoints[i];
            preSum[i + 1] = cardPoints[i] + preSum[i];
        }
        int res = 0;
        k = cardPoints.length - k;
        int left = 0, right = k;
        while (right < preSum.length) {
            res = Math.max(res, total - (preSum[right] - preSum[left]));
            left++;
            right++;
        }
        return res;
    }
}
