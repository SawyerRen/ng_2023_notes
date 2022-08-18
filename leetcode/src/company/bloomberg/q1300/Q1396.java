package company.bloomberg.q1300;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1396 {
    class UndergroundSystem {
        Map<Integer, Pair<String, Integer>> travelMap = new HashMap<>();
        Map<String, Pair<Integer, Integer>> timeMap = new HashMap<>();

        public UndergroundSystem() {

        }

        public void checkIn(int id, String stationName, int t) {
            travelMap.put(id, new Pair<>(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            Pair<String, Integer> pair = travelMap.remove(id);
            String route = pair.getKey() + "." + stationName;
            timeMap.putIfAbsent(route, new Pair<>(0, 0));
            int totalTime = timeMap.get(route).getKey() + t - pair.getValue();
            int totalCount = timeMap.get(route).getValue() + 1;
            timeMap.put(route, new Pair<>(totalTime, totalCount));
        }

        public double getAverageTime(String startStation, String endStation) {
            String route = startStation + "." + endStation;
            Pair<Integer, Integer> pair = timeMap.get(route);
            return (double) pair.getKey() / pair.getValue();
        }
    }
}
