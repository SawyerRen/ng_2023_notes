package company.bloomberg.q0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, candidates, new ArrayList<Integer>(), target, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] candidates, ArrayList<Integer> list, int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            helper(res, candidates, list, target - candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
