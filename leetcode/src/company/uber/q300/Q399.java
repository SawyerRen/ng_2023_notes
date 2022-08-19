package company.uber.q300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Q399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        buildMap(equations, values, map);
        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = helper(map, queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>());
        }
        return res;
    }

    private double helper(Map<String, Map<String, Double>> map, String start, String end, HashSet<String> visited) {
        if (!map.containsKey(start)) return -1.0;
        if (map.get(start).containsKey(end)) return map.get(start).get(end);
        visited.add(start);
        for (String next : map.get(start).keySet()) {
            if (visited.contains(next)) continue;
            double res = helper(map, next, end, visited);
            if (res != -1.0) return res * map.get(start).get(next);
        }
        return -1.0;
    }

    private void buildMap(List<List<String>> equations, double[] values, Map<String, Map<String, Double>> map) {
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double v = values[i];
            map.putIfAbsent(a, new HashMap<>());
            map.putIfAbsent(b, new HashMap<>());
            map.get(a).put(b, v);
            map.get(b).put(a, 1 / v);
        }
    }
}
