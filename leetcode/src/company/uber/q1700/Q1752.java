package company.uber.q1700;

public class Q1752 {
    public boolean check(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1) return false;
            }
        }
        if (count == 0) return true;
        return nums[0] >= nums[nums.length - 1];
    }
}
