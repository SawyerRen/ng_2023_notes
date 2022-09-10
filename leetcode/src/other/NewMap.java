package other;

import java.util.HashMap;
import java.util.Map;

public class NewMap {
    static class NewHashMap {
        int addVal;
        int addKey;
        Map<Integer, Integer> map = new HashMap<>();

        void insert(int x, int y) {
            map.put(x - addKey, y - addVal);
        }

        int get(int x) {
            return map.get(x - addKey) + addVal;
        }

        void addToKey(int x) {
            addKey += x;
        }

        void addToValue(int y) {
            addVal += y;
        }
    }

    public static void main(String[] args) {
        NewHashMap map = new NewHashMap();
        map.insert(1, 2);
        map.insert(2, 3);
        map.addToValue(2);
        map.addToKey(1);
        System.out.println(map.get(3));
    }
}
