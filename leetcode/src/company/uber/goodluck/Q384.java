package company.uber.goodluck;

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
            for (int i = 0; i < res.length; i++) {
                int index = random.nextInt(i + 1);
                swap(res, i, index);
            }
            return res;
        }

        private void swap(int[] nums, int i, int j) {
            int n = nums[i];
            nums[i] = nums[j];
            nums[j] = n;
        }
    }
}
