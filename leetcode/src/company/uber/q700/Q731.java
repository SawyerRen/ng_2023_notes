package company.uber.q700;

import java.util.Map;
import java.util.TreeMap;

public class Q731 {
    class MyCalendarTwo {
        TreeMap<Integer, Integer> map;

        public MyCalendarTwo() {
            map = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                count += entry.getValue();
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
