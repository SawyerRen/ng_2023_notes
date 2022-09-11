package company.amazon.q2200;

import java.util.Arrays;

public class Q2294 {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1, j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - nums[j] > k) {
                res++;
                j = i;
            }
        }
        return res;
    }
}
