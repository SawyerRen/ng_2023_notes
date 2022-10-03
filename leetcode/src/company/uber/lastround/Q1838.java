package company.uber.lastround;

import java.util.Arrays;

public class Q1838 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = 0, res = 0;
        long sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (nums[j] * (j - i + 1) > sum + k) {
                sum -= nums[i];
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
