package company.uber.goodluck;

import javafx.util.Pair;

import java.util.*;

public class Q399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        buildMap(map, equations, values);
        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = dfs(map, queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>());
        }
        return res;
    }

    private double dfs(Map<String, Map<String, Double>> map, String s, String e, HashSet<String> visited) {
        if (!map.containsKey(s)) return -1.0;
        if (map.get(s).containsKey(e)) return map.get(s).get(e);
        for (String next : map.get(s).keySet()) {
            if (visited.contains(next)) continue;
            visited.add(next);
            double res = dfs(map, next, e, visited);
            if (res != -1.0) return res * map.get(s).get(next);
            visited.remove(next);
        }
        return -1.0;
    }

    private double bfs(Map<String, Map<String, Double>> map, String s, String e) {
        if (!map.containsKey(s) || !map.containsKey(e)) return -1.0;
        Queue<Pair<String, Double>> queue = new LinkedList<>();
        queue.add(new Pair<>(s, 1.0));
        Set<String> visited = new HashSet<>();
        visited.add(s);
        while (!queue.isEmpty()) {
            Pair<String, Double> poll = queue.poll();
            String cur = poll.getKey();
            double val = poll.getValue();
            if (map.containsKey(cur)) {
                for (String next : map.get(cur).keySet()) {
                    if (next.equals(e)) return val * map.get(cur).get(next);
                    if (visited.contains(next)) continue;
                    visited.add(next);
                    queue.add(new Pair<>(next, val * map.get(cur).get(next)));
                }
            }
        }
        return -1.0;
    }


    private void buildMap(Map<String, Map<String, Double>> map, List<List<String>> equations, double[] values) {
        for (int i = 0; i < equations.size(); i++) {
            String s = equations.get(i).get(0);
            String e = equations.get(i).get(1);
            double v = values[i];
            map.putIfAbsent(s, new HashMap<>());
            map.get(s).put(e, v);
            map.putIfAbsent(e, new HashMap<>());
            map.get(e).put(s, 1 / v);
        }
    }
}
