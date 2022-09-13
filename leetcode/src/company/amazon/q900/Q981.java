package company.amazon.q900;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q981 {
    class TimeMap {
        Map<String, List<Pair<String, Integer>>> map = new HashMap<>();

        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(new Pair<>(value, timestamp));
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";
            List<Pair<String, Integer>> list = map.get(key);
            int left = 0, right = list.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (list.get(mid).getValue() > timestamp) right = mid;
                else left = mid + 1;
            }
            if (left == 0) return "";
            return list.get(left - 1).getKey();
        }
    }
}
