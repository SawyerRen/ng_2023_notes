package company.uber.lastround;

public class Q45 {
    public int jump(int[] nums) {
        int curMax = 0, curLen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curLen >= nums.length - 1) return count;
            curMax = Math.max(curMax, i + nums[i]);
            if (curLen == i) {
                count++;
                curLen = curMax;
            }
        }
        return -1;
    }
}
