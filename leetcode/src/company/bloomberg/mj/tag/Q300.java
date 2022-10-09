package company.bloomberg.mj.tag;

import java.util.ArrayList;
import java.util.List;

public class Q300 {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.isEmpty() || num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int index = search(list, num);
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
