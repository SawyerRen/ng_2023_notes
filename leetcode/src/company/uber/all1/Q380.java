package company.uber.all1;

import java.util.*;

public class Q380 {
    class RandomizedSet {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
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
            int index = indexMap.get(val);
            if (index != list.size() - 1) {
                Integer lastVal = list.get(list.size() - 1);
                list.set(index, lastVal);
                indexMap.put(lastVal, index);
            }
            indexMap.remove(val);
            list.remove(list.size() - 1);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
