package company.uber.goodluck;

import java.util.Arrays;

public class Q16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int minDiff = Math.abs(target - res);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) return sum;
                if (sum < target) {
                    if (minDiff > target - sum) {
                        minDiff = target - sum;
                        res = sum;
                    }
                    left++;
                } else {
                    if (minDiff > sum - target) {
                        minDiff = sum - target;
                        res = sum;
                    }
                    right--;
                }
            }
        }
        return res;
    }
}
