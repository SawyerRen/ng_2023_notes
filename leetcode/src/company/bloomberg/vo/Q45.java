package company.bloomberg.vo;

public class Q45 {
    public int jump(int[] nums) {
        int curLen = 0, curMax = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curLen >= nums.length - 1) return res;
            curMax = Math.max(curMax, i + nums[i]);
            if (curLen == i) {
                curLen = curMax;
                res++;
            }
        }
        return -1;
    }
}
