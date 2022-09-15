package company.amazon.q1400;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Q1429 {
    class FirstUnique {
        LinkedHashSet<Integer> unique = new LinkedHashSet<>();
        HashSet<Integer> duplicate = new HashSet<>();

        public FirstUnique(int[] nums) {
            for (int num : nums) {
                add(num);
            }
        }

        public int showFirstUnique() {
            if (!unique.iterator().hasNext()) return -1;
            return unique.iterator().next();
        }

        public void add(int num) {
            if (duplicate.contains(num)) return;
            if (unique.contains(num)) {
                unique.remove(num);
                duplicate.add(num);
            } else {
                unique.add(num);
            }
        }
    }
}
