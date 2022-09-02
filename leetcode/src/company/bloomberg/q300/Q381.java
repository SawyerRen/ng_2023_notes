package company.bloomberg.q300;

import java.util.*;

public class Q381 {
    class RandomizedCollection {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Set<Integer>> indexMap = new HashMap<>();
        Random random = new Random();

        public RandomizedCollection() {

        }

        public boolean insert(int val) {
            indexMap.putIfAbsent(val, new HashSet<>());
            indexMap.get(val).add(list.size());
            list.add(val);
            return indexMap.get(val).size() == 1;
        }

        public boolean remove(int val) {
            if (!indexMap.containsKey(val) || indexMap.get(val).size() == 0) return false;
            int index = indexMap.get(val).iterator().next();
            indexMap.get(val).remove(index);
            Integer lastVal = list.get(list.size() - 1);
            list.set(index, lastVal);
            indexMap.get(lastVal).add(index);
            indexMap.get(lastVal).remove(list.size() - 1);
            list.remove(list.size() - 1);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
