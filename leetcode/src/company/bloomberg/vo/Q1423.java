package company.bloomberg.vo;

public class Q1423 {
    public int maxScore(int[] cardPoints, int k) {
        int[] preSum = new int[cardPoints.length + 1];
        int total = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            total += cardPoints[i];
            preSum[i + 1] = total;
        }
        int left = 0, right = cardPoints.length - k;
        int res = total - (preSum[right] - preSum[left]);
        while (right < preSum.length) {
            res = Math.max(res, total - (preSum[right] - preSum[left]));
            left++;
            right++;
        }
        return res;
    }
}
