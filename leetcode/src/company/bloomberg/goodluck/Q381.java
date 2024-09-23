package company.bloomberg.goodluck;

import java.util.*;

public class Q381 {
    class RandomizedCollection {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Set<Integer>> indexMap = new HashMap<>(); // 这里改成Set<Integer>去存index
        Random random = new Random();

        public RandomizedCollection() {

        }

        public boolean insert(int val) {
            indexMap.putIfAbsent(val, new HashSet<>());
            indexMap.get(val).add(list.size()); // 新的index加入val对应的set中
            list.add(val);
            return indexMap.get(val).size() == 1;
        }

        public boolean remove(int val) {
            if (!indexMap.containsKey(val) || indexMap.get(val).size() == 0) return false;
            int index = indexMap.get(val).iterator().next(); // 把val对应的index从map中去掉
            indexMap.get(val).remove(index);
            Integer lastVal = list.get(list.size() - 1); // 拿到最后的值，把最后的值的set中，去掉最后那个index，加入val对应的index
            indexMap.get(lastVal).add(index);
            indexMap.get(lastVal).remove(list.size() - 1);
            list.set(index, lastVal); // 在list中更新index对应的值
            list.remove(list.size() - 1);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
