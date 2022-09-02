package company.bloomberg.q1100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1169 {
    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<String[]>> map = new HashMap<>();
        for (String t : transactions) {
            String[] split = t.split(",");
            map.putIfAbsent(split[0], new ArrayList<>());
            map.get(split[0]).add(split);
        }
        List<String> res = new ArrayList<>();
        for (String t : transactions) {
            String[] t1 = t.split(",");
            if (Integer.parseInt(t1[2]) > 1000) {
                res.add(t);
                continue;
            }
            List<String[]> list = map.get(t1[0]);
            for (String[] t2 : list) {
                int time1 = Integer.parseInt(t1[1]);
                int time2 = Integer.parseInt(t2[1]);
                if (Math.abs(time1 - time2) <= 60 && !t1[3].equals(t2[3])) {
                    res.add(t);
                    break;
                }
            }
        }
        return res;
    }
}
