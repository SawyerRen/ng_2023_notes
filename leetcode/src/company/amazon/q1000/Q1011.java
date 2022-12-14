package company.amazon.q1000;

public class Q1011 {
    public int shipWithinDays(int[] weights, int days) {
        int left = 1, right = 1;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 1;
            int cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    count++;
                    cur = 0;
                }
                cur += weight;
            }
            if (count <= days) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
