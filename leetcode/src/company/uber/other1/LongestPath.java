package company.uber.other1;

import java.util.*;

public class LongestPath {
    static int solution(String[][] paths) {
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> preCount = new HashMap<>();
        for (String[] path : paths) {
            map.putIfAbsent(path[0], new HashSet<>());
            map.get(path[0]).add(path[1]);
            preCount.putIfAbsent(path[0], 0);
            preCount.put(path[1], preCount.getOrDefault(path[1], 0) + 1);
        }
        Queue<String> queue = new LinkedList<>();
        for (String s : preCount.keySet()) {
            if (preCount.get(s) == 0) queue.add(s);
        }
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (map.containsKey(poll)) {
                    for (String next : map.get(poll)) {
                        preCount.put(next, preCount.get(next) - 1);
                        if (preCount.get(next) == 0) {
                            queue.add(next);
                        }
                    }
                }
            }
        }
        return res;
    }
}
