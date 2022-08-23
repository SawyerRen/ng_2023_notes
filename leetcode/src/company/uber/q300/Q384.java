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
            int[] temp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                temp[i] = nums[i];
            }
            for (int i = 1; i < nums.length; i++) {
                int j = random.nextInt(i + 1);
                swap(temp, i, j);
            }
            return temp;
        }

        private void swap(int[] temp, int i, int j) {
            int t = temp[i];
            temp[i] = temp[j];
            temp[j] = t;
        }
    }
}
