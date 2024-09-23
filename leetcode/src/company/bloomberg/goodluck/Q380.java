package company.bloomberg.goodluck;

import java.util.*;

public class Q380 {
    class RandomizedSet {
        Map<Integer, Integer> map = new HashMap<>(); // 保存value和对应的index
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        public RandomizedSet() {

        }

        // val加入到list中，保存val对应的index
        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        // 因为arraylist的remove()方法的复杂的是O(N)，只有remove最后一个的复杂度是O(1)
        // 所以如果要remove的val不在最后一个，需要先和最后一个交换再remove
        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            int index = map.get(val);
            // 如果这个数字不在最后一个
            if (index != list.size() - 1) {
                // 得到最后那个数字
                int lastVal = list.get(list.size() - 1);
                // 将map中最后数字的index更新成要去掉的数字的index
                map.put(lastVal, index);
                // 在list中更新index上面的数字
                list.set(index, lastVal);
            }
            // 为什么上面只是把最后一个数字放到index，没有把要去掉的数字更新到list的最后？
            // 因为反正要去掉了，就没必要去更新了
            // 从map和list中去掉最后一个数字
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

    // BBG会把这个题目套一个彩票系统的壳，本质上是一样的
    // 每个User有一个id，可以把这个User加入到系统中，然后随机取出这个User，并且把这个User从系统中去掉
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
