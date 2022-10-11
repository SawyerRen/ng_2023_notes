package company.bloomberg.goodluck;

import java.util.*;

public class Q380 {
    class RandomizedSet {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            int index = map.get(val);
            if (index != list.size() - 1) {
                int lastVal = list.get(list.size() - 1);
                map.put(lastVal, index);
                list.set(index, lastVal);
            }
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

    class LotterySystem {
        class User {
            int id;
        }

        Map<Integer, Integer> indexMap = new HashMap<>();
        Map<Integer, User> userMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        void addUser(int userId) {
            if (indexMap.containsKey(userId)) return;
            indexMap.put(userId, list.size());
            list.add(userId);
        }

        User pickUser() {
            int userId = list.get(new Random().nextInt(list.size()));
            int index = indexMap.get(userId);
            if (index != list.size() - 1) {
                int last = list.get(list.size() - 1);
                indexMap.put(last, index);
                list.set(index, last);
            }
            indexMap.remove(userId);
            list.remove(list.size() - 1);
            return userMap.get(userId);
        }
    }
}
