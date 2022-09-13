package company.amazon.q300;

import java.util.*;

public class Q380 {
    class RandomizedSet {
        Map<Integer, Integer> indexMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if (indexMap.containsKey(val)) return false;
            indexMap.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!indexMap.containsKey(val)) return false;
            Integer index = indexMap.get(val);
            if (index != list.size() - 1) {
                Integer lastVal = list.get(list.size() - 1);
                indexMap.put(lastVal, index);
                list.set(index, lastVal);
            }
            list.remove(list.size() - 1);
            indexMap.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
