package company.uber.q1800;

public class Q1842 {
    public String nextPalindrome(String num) {
        int n = num.length();
        int[] nums = new int[n / 2];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = num.charAt(i) - '0';
        }
        if (!nextPermutation(nums)) return "";
        StringBuilder builder = new StringBuilder();
        for (int i : nums) {
            builder.append(i);
        }
        if (n % 2 == 0) {
            return builder.toString() + builder.reverse().toString();
        } else {
            return builder.toString() + num.charAt(n / 2) + builder.reverse().toString();
        }
    }

    private boolean nextPermutation(int[] nums) {
        int l = nums.length - 2;
        while (l >= 0 && nums[l] >= nums[l + 1]) l--;
        if (l < 0) return false;
        int r = nums.length - 1;
        while (nums[r] <= nums[l]) r--;
        swap(nums, l, r);
        reverse(nums, l + 1, nums.length - 1);
        return true;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}
