package company.amazon.q0;

public class Q53 {
    public int maxSubArray(int[] nums) {
        int res = nums[0], curMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            res = Math.max(res, curMax);
        }
        return res;
    }
}
