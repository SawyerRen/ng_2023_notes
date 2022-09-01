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
            String startStation = checkInMap.get(id).getKey();
            int startTime = checkInMap.get(id).getValue();
            checkInMap.remove(id);
            int duration = t - startTime;
            String route = startStation + "-" + stationName;
            Pair<Integer, Integer> timePair = timeMap.getOrDefault(route, new Pair<>(0, 0));
            timeMap.put(route, new Pair<>(timePair.getKey() + duration, timePair.getValue() + 1));
        }

        public double getAverageTime(String startStation, String endStation) {
            String route = startStation + "-" + endStation;
            Pair<Integer, Integer> pair = timeMap.get(route);
            return (double) pair.getKey() / pair.getValue();
        }
    }
}
