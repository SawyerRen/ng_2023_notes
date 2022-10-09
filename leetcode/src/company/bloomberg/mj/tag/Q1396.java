package company.bloomberg.mj.tag;

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
            Pair<String, Integer> pair = checkInMap.get(id);
            String route = pair.getKey() + "-" + stationName;
            int duration = t - pair.getValue();
            Pair<Integer, Integer> timePair = timeMap.getOrDefault(route, new Pair<>(0, 0));
            timeMap.put(route, new Pair<>(timePair.getKey() + 1, timePair.getValue() + duration));
        }

        public double getAverageTime(String startStation, String endStation) {
            String route = startStation + "-" + endStation;
            Pair<Integer, Integer> pair = timeMap.get(route);
            return (double) pair.getValue() / pair.getKey();
        }
    }
}
