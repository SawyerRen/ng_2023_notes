package company.bloomberg.q300;

import java.util.*;

public class Q381 {
    class RandomizedCollection {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Random random = new Random();

        public RandomizedCollection() {

        }

        public boolean insert(int val) {
            map.putIfAbsent(val, new HashSet<>());
            map.get(val).add(list.size());
            list.add(val);
            return map.get(val).size() == 1;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val) || map.get(val).size() == 0) return false;
            Integer index = map.get(val).iterator().next();
            map.get(val).remove(index);
            Integer lastVal = list.get(list.size() - 1);
            list.set(index, lastVal);
            map.get(lastVal).add(index);
            map.get(lastVal).remove(list.size() - 1);
            list.remove(list.size() - 1);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

}
