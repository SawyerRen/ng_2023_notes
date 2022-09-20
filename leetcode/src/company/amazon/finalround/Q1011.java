package company.amazon.finalround;

public class Q1011 {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 1, cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    cur = 0;
                    count++;
                }
                cur += weight;
            }
            if (count <= days) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
