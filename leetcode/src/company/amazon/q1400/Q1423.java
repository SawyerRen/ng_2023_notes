package company.amazon.q1400;

public class Q1423 {
    public int maxScore(int[] cardPoints, int k) {
        int[] preSum = new int[cardPoints.length + 1];
        int total = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            preSum[i + 1] = preSum[i] + cardPoints[i];
            total += cardPoints[i];
        }
        int res = 0;
        int left = 0, right = cardPoints.length - k;
        while (right < preSum.length) {
            res = Math.max(res, total - (preSum[right] - preSum[left]));
            left++;
            right++;
        }
        return res;
    }
}
