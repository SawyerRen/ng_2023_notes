package company.amazon.finalround;

public class Q287 {
    public int findDuplicate(int[] nums) {
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index] < 0) {
                res = index;
                break;
            }
            nums[index] = -nums[index];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        return res;
    }
}
