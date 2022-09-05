package company.uber.q700;

import java.util.TreeMap;

public class Q731 {
    class MyCalendarTwo {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        public MyCalendarTwo() {

        }

        public boolean book(int start, int end) {
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
            int count = 0;
            for (Integer value : map.values()) {
                count += value;
                if (count > 2) {
                    map.put(start, map.get(start) - 1);
                    map.put(end, map.get(end) + 1);
                    return false;
                }
            }
            return true;
        }
    }
}
