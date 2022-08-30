package company.bloomberg.q300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q300 {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.isEmpty() || num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int index = getIndex(list, num);
                list.set(index, num);
            }
        }
        return list.size();
    }

    private int getIndex(List<Integer> list, int num) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= num) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
