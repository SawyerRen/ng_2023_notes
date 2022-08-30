package company.bloomberg.q1600;

import java.util.*;

public class Q1656 {
    class OrderedStream {
        Map<Integer, String> map = new HashMap<>();
        int index = 0;

        public OrderedStream(int n) {

        }

        public List<String> insert(int idKey, String value) {
            map.put(idKey, value);
            List<String> res = new ArrayList<>();
            while (map.containsKey(index + 1)) {
                res.add(map.get(index + 1));
                index++;
            }
            return res;
        }
    }
}
