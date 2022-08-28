package company.bloomberg.q100;

import java.util.HashSet;
import java.util.Set;

public class Q128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int count = 1;
                set.remove(num);
                while (set.contains(num + 1)) {
                    set.remove(num + 1);
                    num++;
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
