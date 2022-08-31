package company.bloomberg.q300;

import java.util.ArrayList;
import java.util.List;

public class Q300 {
    public int lengthOfLIS(int[] nums) {
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
