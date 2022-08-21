package company.amazon.q1100;

import javafx.util.Pair;

import java.util.*;

public class Q1152 {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair<Integer, String>>> map = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            map.putIfAbsent(username[i], new ArrayList<>());
            map.get(username[i]).add(new Pair<>(timestamp[i], website[i]));
        }
        Map<String, Integer> countMap = new HashMap<>();
        String res = "";
        for (List<Pair<Integer, String>> pairs : map.values()) {
            pairs.sort((a, b) -> a.getKey() - b.getKey());
            int size = pairs.size();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < size - 2; i++) {
                for (int j = i + 1; j < size - 1; j++) {
                    for (int k = j + 1; k < size; k++) {
                        String pattern = pairs.get(i).getValue() + "_" + pairs.get(j).getValue() + "_"
                                + pairs.get(k).getValue();
                        if (set.contains(pattern)) continue;
                        countMap.put(pattern, countMap.getOrDefault(pattern, 0) + 1);
                        set.add(pattern);
                        if (res.equals("") || countMap.get(pattern) > countMap.get(res)
                                || (countMap.get(pattern).equals(countMap.get(res)) && pattern.compareTo(res) < 0)) {
                            res = pattern;
                        }
                    }
                }
            }
        }
        List<String> list = new ArrayList<>(Arrays.asList(res.split("_")));
        return list;
    }
}
