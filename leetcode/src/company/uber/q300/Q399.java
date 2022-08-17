package company.uber.q300;

import java.util.*;

public class Q399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        buildMap(map, equations, values);
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            res[i] = dfs(map, queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>());
        }
        return res;
    }

    private double dfs(Map<String, Map<String, Double>> map, String s, String t, Set<String> visited) {
        if (!map.containsKey(s)) return -1.0;
        if (map.get(s).containsKey(t)) return map.get(s).get(t);
        visited.add(s);
        for (String s1 : map.get(s).keySet()) {
            if (visited.contains(s1)) continue;
            double temp = dfs(map, s1, t, visited);
            if (temp != -1.0) return map.get(s).get(s1) * temp;
        }
        return -1.0;
    }

    private void buildMap(Map<String, Map<String, Double>> map, List<List<String>> equations, double[] values) {
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
