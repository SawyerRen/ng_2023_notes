package company.bloomberg.r2;

import java.util.Arrays;

public class Q611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int right = 2; right < nums.length; right++) {
            int left = 0, mid = right - 1;
            while (left < mid) {
                if (nums[left] + nums[mid] > nums[right]) {
                    res += mid - left;
                    mid--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
