package company.uber.all1;

import javafx.util.Pair;

import java.util.*;

public class Q399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = buildMap(equations, values);
        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
//            res[i] = bfs(map, queries.get(i).get(0), queries.get(i).get(1));
            res[i] = dfs(map, queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>());
        }
        return res;
    }

    private double dfs(Map<String, Map<String, Double>> map, String start, String end, HashSet<String> visited) {
        if (!map.containsKey(start)) return -1.0;
        if (map.get(start).containsKey(end)) return map.get(start).get(end);
        for (String next : map.get(start).keySet()) {
            if (visited.contains(next)) continue;
            visited.add(next);
            double res = dfs(map, next, end, visited);
            if (res != -1.0) return res * map.get(start).get(next);
        }
        return -1.0;
    }

    private double bfs(Map<String, Map<String, Double>> map, String start, String end) {
        if (!map.containsKey(start) || !map.containsKey(end)) return -1.0;
        Queue<Pair<String, Double>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new Pair<>(start, 1.0));
        visited.add(start);
        while (!queue.isEmpty()) {
            Pair<String, Double> poll = queue.poll();
            String s = poll.getKey();
            double v = poll.getValue();
            if (s.equals(end)) return v;
            if (map.containsKey(s)) {
                for (String next : map.get(s).keySet()) {
                    if (visited.contains(next)) continue;
                    visited.add(next);
                    queue.add(new Pair<>(next, v * map.get(s).get(next)));
                }
            }
        }
        return -1.0;
    }

    private Map<String, Map<String, Double>> buildMap(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double v = values[i];
            map.putIfAbsent(a, new HashMap<>());
            map.get(a).put(b, v);
            map.putIfAbsent(b, new HashMap<>());
            map.get(b).put(a, 1 / v);
        }
        return map;
    }
}
