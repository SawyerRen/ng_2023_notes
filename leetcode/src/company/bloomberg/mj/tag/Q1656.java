package company.bloomberg.mj.tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1656 {
    class OrderedStream {
        Map<Integer, String> map = new HashMap<>();
        int index = 1;

        public OrderedStream(int n) {

        }

        public List<String> insert(int idKey, String value) {
            List<String> res = new ArrayList<>();
            map.put(idKey, value);
            while (map.containsKey(index)) {
                res.add(map.get(index++));
            }
            return res;
        }
    }
}
