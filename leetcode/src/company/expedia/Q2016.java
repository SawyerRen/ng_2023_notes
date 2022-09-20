package company.expedia;

public class Q2016 {
    public int maximumDifference(int[] nums) {
        int min = nums[0], res = 0;
        for (int num : nums) {
            min = Math.min(num, min);
            res = Math.max(res, num - min);
        }
        return res == 0 ? -1 : res;
    }
}
