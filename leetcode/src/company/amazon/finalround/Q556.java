package company.amazon.finalround;

public class Q556 {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        int[] nums = new int[s.length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = s.charAt(i) - '0';
        }
        if (!getNext(nums)) return -1;
        StringBuilder builder = new StringBuilder();
        for (int num : nums) {
            builder.append(num);
        }
        long res = Long.parseLong(builder.toString());
        if (res > Integer.MAX_VALUE) return -1;
        return (int) res;
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
        int n = nums[l];
        nums[l] = nums[r];
        nums[r] = n;
    }
}
