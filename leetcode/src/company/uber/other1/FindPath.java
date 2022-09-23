package company.uber.other1;

import javafx.util.Pair;

import java.util.*;

public class FindPath {
    public static void main(String[] args) {
        String[][] travels = {{"Dallas", "Chicago"}, {"Dallas", "Detroit"}, {"Chicago", "Dallas"}, {"Chicago", "Milwaukee"}};
        int[][] time = {{1, 2}, {2, 5}, {4, 5}, {3, 4}};
        System.out.println(solution(travels, time, "Dallas", "Milwaukee"));
    }

    private static String solution(String[][] travels, int[][] time, String start, String end) {
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, List<Pair<Integer, Integer>>> timeMap = new HashMap<>();
        for (int i = 0; i < travels.length; i++) {
            String s = travels[i][0], e = travels[i][1];
            int t1 = time[i][0], t2 = time[i][1];
            map.putIfAbsent(s, new HashSet<>());
            map.get(s).add(e);
            String route = s + "-" + e;
            timeMap.putIfAbsent(route, new ArrayList<>());
            timeMap.get(route).add(new Pair<>(t1, t2));
        }
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(start, 0));
        while (!queue.isEmpty()) {
            Pair<String, Integer> poll = queue.poll();
            String path = poll.getKey();
            int curTime = poll.getValue();
            String[] split = path.split("-");
            String curCity = split[split.length - 1];
            if (map.containsKey(curCity)) {
                for (String next : map.get(curCity)) {
                    String route = curCity + "-" + next;
                    if (timeMap.containsKey(route)) {
                        for (Pair<Integer, Integer> pair : timeMap.get(route)) {
                            if (pair.getKey() <= curTime) continue;
                            if (next.equals(end)) return route;
                            queue.add(new Pair<>(route, pair.getValue()));
                        }
                    }
                }
            }
        }
        return "";
    }
}
