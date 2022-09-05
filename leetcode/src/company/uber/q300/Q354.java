package company.uber.q300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = envelopes[i][1];
        }
        return lengthOfLIS(heights);
    }

    public  int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.size() == 0 || num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int index = getIndex(list, num);
                list.set(index, num);
            }
        }
        return list.size();
    }

    private int getIndex(List<Integer> nums, int target) {
        int left = 0, right = nums.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
