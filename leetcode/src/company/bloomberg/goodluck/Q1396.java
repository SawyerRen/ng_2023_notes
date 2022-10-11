package company.bloomberg.goodluck;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Q1396 {
    class UndergroundSystem {
        Map<Integer, Pair<String, Integer>> checkInMap = new HashMap<>();
        Map<String, Pair<Integer, Integer>> timeMap = new HashMap<>();

        public UndergroundSystem() {

        }
        // O(1)
        public void checkIn(int id, String stationName, int t) {
            checkInMap.put(id, new Pair<>(stationName, t));
        }

        // O(1)
        public void checkOut(int id, String stationName, int t) {
            Pair<String, Integer> checkIn = checkInMap.get(id);
            String route = checkIn.getKey() + "-" + stationName;
            int duration = t - checkIn.getValue();
            Pair<Integer, Integer> pair = timeMap.getOrDefault(route, new Pair<>(0, 0));
            timeMap.put(route, new Pair<>(pair.getKey() + 1, pair.getValue() + duration));
        }

        // O(1)
        public double getAverageTime(String startStation, String endStation) {
            String route = startStation + "-" + endStation;
            Pair<Integer, Integer> pair = timeMap.get(route);
            return (double) pair.getValue() / pair.getKey();
        }
    }
}
