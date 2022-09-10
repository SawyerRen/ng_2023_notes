package company.amazon.q0;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            helper(nums, res, i);
        }
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, int i) {
        int target = -nums[i];
        HashSet<Integer> set = new HashSet<>();
        for (int j = i + 1; j < nums.length; j++) {
            if (set.contains(target - nums[j])) {
                res.add(Arrays.asList(nums[i], target - nums[j], nums[j]));
                while (j + 1 < nums.length && nums[j + 1] == nums[j]) j++;
            }
            set.add(nums[j]);
        }
    }
}
