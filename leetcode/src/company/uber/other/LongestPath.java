package company.uber.other;

import java.util.*;

public class LongestPath {
    static int solution1(String[][] paths) {
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> preCount = new HashMap<>();
        for (String[] path : paths) {
            preCount.put(path[0], 0);
            preCount.put(path[1], 0);
        }
        for (String[] path : paths) {
            map.putIfAbsent(path[0], new HashSet<>());
            map.get(path[0]).add(path[1]);
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
                        if (preCount.get(next) == 0) queue.add(next);
                    }
                }
            }
        }
        return res;
    }

    static List<String> solution(String[][] paths) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String[] path : paths) {
            map.putIfAbsent(path[0], new HashSet<>());
            map.get(path[0]).add(path[1]);
        }
        Map<String, List<String>> memo = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String start : map.keySet()) {
            List<String> list = helper(memo, start, map, new HashSet<String>());
            if (list.size() > res.size()) res = list;
        }
        return res;
    }

    private static List<String> helper(Map<String, List<String>> memo, String start, Map<String, Set<String>> map, HashSet<String> visited) {
        if (!map.containsKey(start)) {
            List<String> list = new ArrayList<>();
            list.add(start);
            return list;
        }
        if (memo.containsKey(start)) return memo.get(start);
        List<String> res = new ArrayList<>();
        if (map.containsKey(start)) {
            for (String next : map.get(start)) {
                if (visited.contains(next)) continue;
                List<String> list = new ArrayList<>();
                list.add(start);
                List<String> nextList = helper(memo, next, map, visited);
                list.addAll(nextList);
                if (list.size() > res.size()) {
                    res = list;
                }
            }
        }
        memo.put(start, res);
        return res;
    }

    public static void main(String[] args) {
        String[][] paths = {{"b", "a"}, {"a", "f"}, {"f", "c"}};
        System.out.println(solution(paths));
        System.out.println(solution1(paths));
    }
}
