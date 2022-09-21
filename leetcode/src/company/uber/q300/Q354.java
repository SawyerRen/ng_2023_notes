package company.uber.q300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] nums = new int[envelopes.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = envelopes[i][1];
        }
        return helper(nums);
    }

    private int helper(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            int index = search(list, num);
            if (index == list.size()) {
                list.add(num);
            } else {
                list.set(index, num);
            }
        }
        return list.size();
    }

    private int search(List<Integer> list, int num) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= num) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
