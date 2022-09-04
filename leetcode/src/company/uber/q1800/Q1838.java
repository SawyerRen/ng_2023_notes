package company.uber.q1800;

import java.util.Arrays;

public class Q1838 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        int i = 0, j = 0, res = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum + k < nums[j] * (j - i + 1)) {
                sum -= nums[i];
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
