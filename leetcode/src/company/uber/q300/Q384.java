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
            return this.nums;
        }

        public int[] shuffle() {
            int[] clone = nums.clone();
            for (int i = 1; i < nums.length; i++) {
                int j = random.nextInt(i + 1);
                swap(clone, i, j);
            }
            return clone;
        }

        private void swap(int[] clone, int i, int j) {
            int t = clone[i];
            clone[i] = clone[j];
            clone[j] = t;
        }
    }
}
