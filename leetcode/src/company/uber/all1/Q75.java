package company.uber.all1;

public class Q75 {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int n = nums[i];
        nums[i] = nums[j];
        nums[j] = n;
    }
}
