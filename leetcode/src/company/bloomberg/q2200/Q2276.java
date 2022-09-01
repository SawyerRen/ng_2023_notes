package company.bloomberg.q2200;

import java.util.TreeMap;

public class Q2276 {
    class CountIntervals {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int count = 0;

        public CountIntervals() {

        }

        public void add(int left, int right) {
            int l = left, r = right;
            while (map.floorKey(r) != null && map.get(map.floorKey(r)) >= l) {
                int preL = map.floorKey(r);
                int preR = map.get(preL);
                count -= (preR - preL + 1);
                map.remove(preL);
                l = Math.min(l, preL);
                r = Math.max(r, preR);
            }
            map.put(l, r);
            count += (r - l + 1);
        }

        public int count() {
            return count;
        }
    }
}
