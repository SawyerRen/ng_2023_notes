package company.bloomberg.q1300;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Q1396 {
    class UndergroundSystem {
        Map<Integer, Pair<Integer, String>> startMap = new HashMap<>();
        Map<String, Pair<Integer, Integer>> timeMap = new HashMap<>();

        public UndergroundSystem() {

        }

        public void checkIn(int id, String stationName, int t) {
            startMap.put(id, new Pair<>(t, stationName));
        }

        public void checkOut(int id, String stationName, int t) {
            Pair<Integer, String> start = startMap.remove(id);
            int duration = t - start.getKey();
            String route = start.getValue() + "_" + stationName;
            Pair<Integer, Integer> timePair = timeMap.getOrDefault(route, new Pair<>(0, 0));
            int time = timePair.getKey() + duration;
            int count = timePair.getValue() + 1;
            timeMap.put(route, new Pair<>(time, count));
        }

        public double getAverageTime(String startStation, String endStation) {
            String route = startStation + "_" + endStation;
            Pair<Integer, Integer> pair = timeMap.get(route);
            return (double) pair.getKey() / pair.getValue();
        }
    }
}
