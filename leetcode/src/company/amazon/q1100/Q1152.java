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
        String res = "";
        int max = 0;
        Map<String, Integer> countMap = new HashMap<>();
        for (List<Pair<Integer, String>> list : map.values()) {
            list.sort((a, b) -> a.getKey() - b.getKey());
            Set<String> set = new HashSet<>();
            for (int i = 0; i < list.size() - 2; i++) {
                for (int j = i + 1; j < list.size() - 1; j++) {
                    for (int k = j + 1; k < list.size(); k++) {
                        String pattern = list.get(i).getValue() + "-" + list.get(j).getValue() + "-" + list.get(k).getValue();
                        if (!set.contains(pattern)) {
                            countMap.put(pattern, countMap.getOrDefault(pattern, 0) + 1);
                            set.add(pattern);
                            if (countMap.get(pattern) > max) {
                                max = countMap.get(pattern);
                                res = pattern;
                            } else if (countMap.get(pattern) == max && pattern.compareTo(res) < 0) {
                                res = pattern;
                            }
                        }
                    }
                }
            }
        }
        return new ArrayList<>(Arrays.asList(res.split("-")));
    }
}
