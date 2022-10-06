package company.bloomberg.all.q0;

public class Q31 {
    public void nextPermutation(int[] nums) {
        int l = nums.length - 2;
        while (l >= 0 && nums[l] >= nums[l + 1]) {
            l--;
        }
        if (l < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int r = nums.length - 1;
        while (nums[l] >= nums[r]) {
            r--;
        }
        swap(nums, l, r);
        reverse(nums, l + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }

    private void swap(int[] nums, int i, int r) {
        int n = nums[i];
        nums[i] = nums[r];
        nums[r] = n;
    }
}
