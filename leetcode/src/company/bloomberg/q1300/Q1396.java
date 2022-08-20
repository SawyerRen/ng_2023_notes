package company.bloomberg.q1300;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Q1396 {
    class UndergroundSystem {
        Map<Integer, Pair<String, Integer>> startMap = new HashMap<>();
        Map<String, Pair<Integer, Integer>> routeMap = new HashMap<>();

        public UndergroundSystem() {

        }

        public void checkIn(int id, String stationName, int t) {
            startMap.put(id, new Pair<>(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            Pair<String, Integer> start = startMap.get(id);
            String route = start.getKey() + "_" + stationName;
            int duration = t - start.getValue();
            startMap.remove(id);
            Pair<Integer, Integer> routePair = routeMap.getOrDefault(route, new Pair<>(0, 0));
            int time = routePair.getKey() + duration;
            int count = routePair.getValue() + 1;
            routeMap.put(route, new Pair<>(time, count));
        }

        public double getAverageTime(String startStation, String endStation) {
            Pair<Integer, Integer> pair = routeMap.get(startStation + "_" + endStation);
            return (double) pair.getKey() / pair.getValue();
        }
    }
}
