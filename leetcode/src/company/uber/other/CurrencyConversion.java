package company.uber.other;

import java.util.*;

public class CurrencyConversion {
    static public double solution(String[][] currency, double[] rates, String start, String end) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < currency.length; i++) {
            String a = currency[i][0];
            String b = currency[i][1];
            map.putIfAbsent(a, new HashMap<>());
            map.get(a).put(b, rates[i]);
            map.putIfAbsent(b, new HashMap<>());
            map.get(b).put(a, 1 / rates[i]);
        }
//        return dfs(map, start, end, new HashSet<String>());
        return bfs(map, start, end);
    }

    private static double bfs(Map<String, Map<String, Double>> map, String start, String end) {
        Queue<String> queue = new LinkedList<>();
        Queue<Double> vals = new LinkedList<>();
        queue.add(start);
        vals.add(1.0);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            Double val = vals.poll();
            if (map.containsKey(poll)) {
                for (String next : map.get(poll).keySet()) {
                    if (visited.contains(next)) continue;
                    if (next.equals(end)) return val * map.get(poll).get(next);
                    queue.add(next);
                    vals.add(val * map.get(poll).get(next));
                    visited.add(next);
                }
            }
        }
        return -1;
    }

    private static double dfs(Map<String, Map<String, Double>> map, String start, String end, HashSet<String> visited) {
        if (!map.containsKey(start)) return -1.0;
        if (map.get(start).containsKey(end)) return map.get(start).get(end);
        for (String next : map.get(start).keySet()) {
            if (visited.contains(next)) continue;
            visited.add(next);
            double res = dfs(map, next, end, visited);
            if (res != -1.0) return res * map.get(start).get(next);
            visited.remove(next);
        }
        return -1.0;
    }

    public static void main(String[] args) {
        String[][] c = {{"USD", "JPY"}, {"USD", "AUD"}, {"JPY", "GBP"}};
        double[] r = {110, 1.45, 0.0070};
        System.out.println(solution(c, r, "GBP", "AUD"));
    }
}
