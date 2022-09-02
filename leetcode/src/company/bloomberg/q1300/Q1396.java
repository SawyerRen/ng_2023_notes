package company.bloomberg.q1300;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Q1396 {
    class UndergroundSystem {
        Map<Integer, Pair<String, Integer>> checkInMap = new HashMap<>();
        Map<String, Pair<Integer, Integer>> timeMap = new HashMap<>();

        public UndergroundSystem() {

        }

        public void checkIn(int id, String stationName, int t) {
            checkInMap.put(id, new Pair<>(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            Pair<String, Integer> start = checkInMap.get(id);
            int duration = t - start.getValue();
            String route = start.getKey() + "_" + stationName;
            Pair<Integer, Integer> pair = timeMap.getOrDefault(route, new Pair<>(0, 0));
            timeMap.put(route, new Pair<>(pair.getKey() + duration, pair.getValue() + 1));
        }

        public double getAverageTime(String startStation, String endStation) {
            String route = startStation + "_" + endStation;
            return (double) timeMap.get(route).getKey() / timeMap.get(route).getValue();
        }
    }
}
