package company.uber.all1;

public class Q53 {
    public int maxSubArray(int[] nums) {
        int res = nums[0], curMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            res = Math.max(res, curMax);
        }
        return res;
    }
}
