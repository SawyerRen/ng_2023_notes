package company.uber.lastround;

public class Q34 {
    public int[] searchRange(int[] nums, int target) {
        int left = leftBound(nums, target);
        if (left == nums.length || nums[left] != target) return new int[]{-1, -1};
        int right = leftBound(nums, target + 1);
        return new int[]{left, right - 1};
    }

    private int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
