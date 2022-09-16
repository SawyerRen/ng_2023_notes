package company.amazon.finalround;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Q1429 {
    class FirstUnique {
        LinkedHashSet<Integer> unique = new LinkedHashSet<>();
        Set<Integer> duplicate = new HashSet<>();

        public FirstUnique(int[] nums) {
            for (int num : nums) {
                add(num);
            }
        }

        public int showFirstUnique() {
            if (unique.isEmpty()) return -1;
            for (Integer integer : unique) {
                return integer;
            }
            return -1;
        }

        public void add(int value) {
            if (!duplicate.contains(value) && !unique.contains(value)) {
                unique.add(value);
            } else if (unique.contains(value)) {
                duplicate.add(value);
                unique.remove(value);
            }
        }
    }
}
