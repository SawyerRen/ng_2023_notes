package company.uber.all1;

import java.util.Arrays;

public class Q16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int minDiff = Math.abs(target - res);
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) return sum;
                if (sum < target) {
                    if (target - sum < minDiff) {
                        minDiff = target - sum;
                        res = sum;
                    }
                    l++;
                } else {
                    if (sum - target < minDiff) {
                        minDiff = sum - target;
                        res = sum;
                    }
                    r--;
                }
            }
        }
        return res;
    }
}
