package company.uber.other;

import javafx.util.Pair;

import java.util.*;

public class FindPath {
    static String solution(String[][] travel, int[][] time, String start, String end) {
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, List<Pair<Integer, Integer>>> timeMap = new HashMap<>();
        for (int i = 0; i < travel.length; i++) {
            String s = travel[i][0], t = travel[i][1];
            int t1 = time[i][0], t2 = time[i][1];
            map.putIfAbsent(s, new HashSet<>());
            map.get(s).add(t);
            String route = s + "-" + t;
            timeMap.putIfAbsent(route, new ArrayList<>());
            timeMap.get(route).add(new Pair<>(t1, t2));
        }
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(start, 0));
        while (!queue.isEmpty()) {
            Pair<String, Integer> poll = queue.poll();
            int curTime = poll.getValue();
            String path = poll.getKey();
            String[] split = path.split("-");
            String curCity = split[split.length - 1];
            if (map.containsKey(curCity)) {
                for (String nextCity : map.get(curCity)) {
                    String route = curCity + "-" + nextCity;
                    for (Pair<Integer, Integer> pair : timeMap.get(route)) {
                        if (pair.getKey() > curTime) {
                            String nextPath = path + "-" + nextCity;
                            if (nextCity.equals(end)) return nextPath;
                            queue.add(new Pair<>(nextPath, pair.getValue()));
                        }
                    }
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[][] travels = {{"Dallas", "Chicago"}, {"Dallas", "Detroit"}, {"Chicago", "Dallas"}, {"Chicago", "Milwaukee"}};
        int[][] time = {{1, 2}, {2, 5}, {4, 5}, {3, 4}};
        System.out.println(solution(travels, time, "Dallas", "Milwaukee"));
    }
}
