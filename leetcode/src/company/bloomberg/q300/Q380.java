package company.bloomberg.q300;

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
            Integer index = indexMap.remove(val);
            int lastVal = list.get(list.size() - 1);
            list.set(index, lastVal);
            indexMap.put(lastVal, index);
            list.remove(list.size() - 1);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

}
