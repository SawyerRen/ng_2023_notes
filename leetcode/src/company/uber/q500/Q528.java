package company.uber.q500;

import java.util.Random;

public class Q528 {
    class Solution {
        Random random;
        int[] preSum;

        public Solution(int[] w) {
            random = new Random();
            int sum = 0;
            preSum = new int[w.length];
            for (int i = 0; i < w.length; i++) {
                sum += w[i];
                preSum[i] = sum;
            }
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
