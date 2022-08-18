package company.bloomberg.q1600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1656 {
    class OrderedStream {
        String[] values;
        int nextIndex;

        public OrderedStream(int n) {
            values = new String[n + 1];
            nextIndex = 1;
        }

        public List<String> insert(int idKey, String value) {
            values[idKey] = value;
            List<String> res = new ArrayList<>();
            while (nextIndex < values.length && values[nextIndex] != null) {
                res.add(values[nextIndex++]);
            }
            return res;
        }
    }
}
