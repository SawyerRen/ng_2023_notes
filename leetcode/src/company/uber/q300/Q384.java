package company.uber.q300;

import java.util.Random;

public class Q384 {
    class Solution {
        int[] nums;
        Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            int[] res = nums.clone();
            for (int i = 1; i < res.length; i++) {
                int j = random.nextInt(i + 1);
                swap(res, i, j);
            }
            return res;
        }

        private void swap(int[] res, int i, int j) {
            int n = res[i];
            res[i] = res[j];
            res[j] = n;
        }
    }
}
