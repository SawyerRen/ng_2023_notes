package company.uber.all1;

import java.util.TreeMap;

public class Q729 {
    class MyCalendar {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            Integer floorKey = map.floorKey(start);
            if (floorKey != null && map.get(floorKey) > start) return false;
            Integer ceilingKey = map.ceilingKey(start);
            if (ceilingKey != null && ceilingKey < end) return false;
            map.put(start, end);
            return true;
        }
    }
}
