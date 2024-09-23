package company.bloomberg.goodluck;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Q1396 {
    class UndergroundSystem {
        // 保存一个id checkin的数据，<id, Pair<checkin的站名, checkin的时间>>
        Map<Integer, Pair<String, Integer>> checkInMap = new HashMap<>(); 
        // 保存一条路径耗时的信息, <路径, Pair<行驶的次数，行驶的总时间>>
        Map<String, Pair<Integer, Integer>> timeMap = new HashMap<>();

        public UndergroundSystem() {

        }
        // O(1)
        public void checkIn(int id, String stationName, int t) {
            checkInMap.put(id, new Pair<>(stationName, t));
        }

        // O(1)
        public void checkOut(int id, String stationName, int t) {
            Pair<String, Integer> checkIn = checkInMap.get(id); // 根据id拿到checkin的车站和时间
            String route = checkIn.getKey() + "-" + stationName; // 用checkin车站-checkout车站组成String表示路径
            int duration = t - checkIn.getValue(); // 行驶时长 = checkout时间 - checkin时间
            Pair<Integer, Integer> pair = timeMap.getOrDefault(route, new Pair<>(0, 0)); // 取出路径的耗时信息
            timeMap.put(route, new Pair<>(pair.getKey() + 1, pair.getValue() + duration)); // 行驶次数+1，行驶总时长+duration
        }

        // O(1)
        public double getAverageTime(String startStation, String endStation) {
            String route = startStation + "-" + endStation; // 车站组成路径
            Pair<Integer, Integer> pair = timeMap.get(route); // 路径的耗时信息
            return (double) pair.getValue() / pair.getKey(); // 平均时长 = 总时长/次数
        }
    }
}
