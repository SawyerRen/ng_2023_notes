package company.uber.q300;

import java.util.*;

public class Q399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            map.putIfAbsent(a, new HashMap<>());
            map.get(a).put(b, values[i]);
            map.putIfAbsent(b, new HashMap<>());
            map.get(b).put(a, 1 / values[i]);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = bfs(map, queries.get(i).get(0), queries.get(i).get(1));
        }
        return res;
    }

    private double bfs(Map<String, Map<String, Double>> map, String start, String end) {
        Queue<String> queue = new LinkedList<>();
        Queue<Double> vals = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(start);
        queue.add(start);
        vals.add(1.0);
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            Double val = vals.poll();

            if (map.containsKey(poll)) {
                for (String next : map.get(poll).keySet()) {
                    if (visited.contains(next)) continue;
                    if (next.equals(end)) return val * map.get(poll).get(next);
                    visited.add(next);
                    queue.add(next);
                    vals.add(val * map.get(poll).get(next));
                }
            }
        }
        return -1.0;
    }
}
