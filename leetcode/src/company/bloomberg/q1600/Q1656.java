package company.bloomberg.q1600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1656 {
    class OrderedStream {
        Map<Integer, String> map = new HashMap<>();
        int pointer = 1;

        public OrderedStream(int n) {

        }

        public List<String> insert(int idKey, String value) {
            map.put(idKey, value);
            List<String> res = new ArrayList<>();
            while (map.containsKey(pointer)) {
                res.add(map.get(pointer++));
            }
            return res;
        }
    }
}
