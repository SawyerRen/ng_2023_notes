package company.amazon.finalround;

import java.util.*;

public class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            helper(nums, i, res);
        }
        return res;
    }

    private void helper(int[] nums, int i, List<List<Integer>> res) {
        int target = -nums[i];
        Set<Integer> set = new HashSet<>();
        for (int j = i + 1; j < nums.length; j++) {
            if (set.contains(target - nums[j])) {
                res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], target - nums[j])));
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) j++;
            }
            set.add(nums[j]);
        }
    }
}
