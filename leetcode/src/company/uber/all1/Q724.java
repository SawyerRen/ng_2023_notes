package company.uber.all1;

public class Q724 {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum * 2 == total - nums[i]) return i;
            sum += nums[i];
        }
        return -1;
    }
}
