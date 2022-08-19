package company.uber.q1800;

public class Q1842 {
    public String nextPalindrome(String num) {
        int len = num.length();
        int[] nums = new int[len / 2];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = num.charAt(i) - '0';
        }
        if (!getNext(nums)) return "";
        StringBuilder builder = new StringBuilder();
        for (int i : nums) {
            builder.append(i);
        }
        boolean even = len % 2 == 0;
        if (even) return builder.toString() + builder.reverse().toString();
        else return builder.toString() + num.charAt(len / 2) + builder.reverse().toString();
    }

    private boolean getNext(int[] nums) {
        int l = nums.length - 2;
        while (l >= 0 && nums[l] >= nums[l + 1]) l--;
        if (l < 0) return false;
        int r = nums.length - 1;
        while (nums[r] <= nums[l]) r--;
        swap(nums, l, r);
        int i = l + 1, j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
        return true;
    }

    private void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}
