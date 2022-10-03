package company.uber.lastround;

import javafx.util.Pair;

import java.util.*;

public class Q399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
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
        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
//            res[i] = dfs(map, queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>());
            res[i] = bfs(map, queries.get(i).get(0), queries.get(i).get(1));
        }
        return res;
    }

    double bfs(Map<String, Map<String, Double>> map, String s, String e) {
        if (!map.containsKey(s) || !map.containsKey(e)) return -1.0;
        Queue<Pair<String, Double>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new Pair<>(s, 1.0));
        visited.add(s);
        while (!queue.isEmpty()) {
            Pair<String, Double> poll = queue.poll();
            String cur = poll.getKey();
            Double value = poll.getValue();
            if (cur.equals(e)) return value;
            if (map.containsKey(cur)) {
                for (String next : map.get(cur).keySet()) {
                    if (visited.contains(next)) continue;
                    visited.add(next);
                    queue.add(new Pair<>(next, value * map.get(cur).get(next)));
                }
            }
        }
        return -1.0;
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
        return -1;
    }
}
