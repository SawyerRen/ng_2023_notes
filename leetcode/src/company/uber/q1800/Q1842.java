package company.uber.q1800;

public class Q1842 {
    public String nextPalindrome(String num) {
        int[] nums = new int[num.length() / 2];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = num.charAt(i) - '0';
        }
        if (!next(nums)) return "";
        StringBuilder builder = new StringBuilder();
        for (int i : nums) {
            builder.append(i);
        }
        if (num.length() % 2 == 0) {
            return builder.toString() + builder.reverse().toString();
        } else {
            return builder.toString() + num.charAt(num.length() / 2) + builder.reverse().toString();
        }
    }

    private boolean next(int[] nums) {
        int l = nums.length - 2;
        while (l >= 0 && nums[l] >= nums[l + 1]) l--;
        if (l < 0) return false;
        int r = nums.length - 1;
        while (nums[l] >= nums[r]) r--;
        swap(nums, l, r);
        l++;
        r = nums.length - 1;
        while (l < r) {
            swap(nums, l++, r--);
        }
        return true;
    }

    private void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}
