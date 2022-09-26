package company.uber.all1;

public class Q45 {
    public int jump(int[] nums) {
        int count = 0, curMax = 0, curLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curLen >= nums.length - 1) return count;
            curMax = Math.max(curMax, i + nums[i]);
            if (i == curLen) {
                count++;
                curLen = curMax;
            }
        }
        return -1;
    }
}
