package company.bloomberg.goodluck;

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
            String[] split = t.split(",");
            if (Integer.parseInt(split[2]) > 1000) {
                res.add(t);
                continue;
            }
            int time1 = Integer.parseInt(split[1]);
            String city1 = split[3];
            for (String[] split2 : map.get(split[0])) {
                int time2 = Integer.parseInt(split2[1]);
                String city2 = split2[3];
                if (Math.abs(time1 - time2) <= 60 && !city1.equals(city2)) {
                    res.add(t);
                    break;
                }
            }
        }
        return res;
    }
}
