package company.amazon.q100;

import java.util.HashSet;
import java.util.Set;

public class Q128 {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int cur = 1;
                set.remove(num);
                while (set.contains(num + 1)) {
                    set.remove(num + 1);
                    num++;
                    cur++;
                }
                res = Math.max(res, cur);
            }
        }
        return res;
    }
}
