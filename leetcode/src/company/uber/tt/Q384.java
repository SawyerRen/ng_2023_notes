package company.uber.tt;

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
                int index = i + random.nextInt(res.length - i);
                swap(res, index, i);
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
