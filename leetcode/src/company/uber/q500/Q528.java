package company.uber.q500;

import java.util.Random;

public class Q528 {
    class Solution {
        int[] preSum;
        Random random;

        public Solution(int[] w) {
            preSum = new int[w.length];
            int sum = 0;
            for (int i = 0; i < w.length; i++) {
                sum += w[i];
                preSum[i] = sum;
            }
            random = new Random();
        }

        public int pickIndex() {
            int index = random.nextInt(preSum[preSum.length - 1]) + 1;
            int left = 0, right = preSum.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (preSum[mid] >= index) right = mid;
                else left = mid + 1;
            }
            return left;
        }
    }
}
