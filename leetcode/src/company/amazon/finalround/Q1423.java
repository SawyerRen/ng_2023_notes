package company.amazon.finalround;

public class Q1423 {
    public int maxScore(int[] cardPoints, int k) {
        int[] preSum = new int[cardPoints.length + 1];
        int total = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            preSum[i + 1] = preSum[i] + cardPoints[i];
            total += cardPoints[i];
        }
        k = cardPoints.length - k;
        int left = 0, right = k;
        int res = total - (preSum[right] - preSum[left]);
        while (right < preSum.length) {
            res = Math.max(res, total - (preSum[right] - preSum[left]));
            left++;
            right++;
        }
        return res;
    }
}
