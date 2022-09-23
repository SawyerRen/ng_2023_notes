package company.uber.q2100;

public class Q2134 {
    public int minSwaps(int[] nums) {
        int count1 = 0;
        for (int num : nums) {
            if (num == 1) count1++;
        }
        int[] temp = new int[nums.length * 2];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        System.arraycopy(nums, 0, temp, nums.length, nums.length);
        int count = 0;
        int left = 0, right = count1;
        for (int i = left; i < right; i++) {
            if (temp[i] == 1) count++;
        }
        int res = count1 - count;
        while (right < temp.length) {
            if (temp[right] == 1) count++;
            if (temp[left] == 1) count--;
            res = Math.min(res, count1 - count);
            left++;
            right++;
        }
        return res;
    }
}
