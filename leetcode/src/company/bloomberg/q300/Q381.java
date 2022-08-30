package company.bloomberg.q300;

import java.util.*;

public class Q381 {
    class RandomizedCollection {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        Map<Integer, Set<Integer>> indexMap = new HashMap<>();

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
            Integer index = indexMap.get(val).iterator().next();
            indexMap.get(val).remove(index);
            int lastVal = list.get(list.size() - 1);
            list.set(index, lastVal);
            list.remove(list.size() - 1);
            indexMap.get(lastVal).add(index);
            indexMap.get(lastVal).remove(list.size());
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
