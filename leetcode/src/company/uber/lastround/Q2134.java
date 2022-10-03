package company.uber.lastround;

public class Q2134 {
    public int minSwaps(int[] nums) {
        int[] arr = new int[nums.length * 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i % nums.length];
        }
        int count1 = 0;
        for (int i : nums) {
            if (i == 1) count1++;
        }
        int left = 0, right = count1;
        int window1 = 0;
        for (int i = 0; i < right; i++) {
            if (arr[i] == 1) window1++;
        }
        int res = count1 - window1;
        while (right < arr.length) {
            if (arr[right] == 1) window1++;
            if (arr[left] == 1) window1--;
            res = Math.min(res, count1 - window1);
            left++;
            right++;
        }
        return res;
    }
}
