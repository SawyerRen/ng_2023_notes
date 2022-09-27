package company.deshaw;

public class Q1004 {
    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0, res = 0;
        int count = 0;
        while (j < nums.length) {
            if (nums[j] == 0) count++;
            while (count > k) {
                if (nums[i] == 0) count--;
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
