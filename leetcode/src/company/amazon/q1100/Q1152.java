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
        int maxCount = 0;
        String s = "";
        for (List<Pair<Integer, String>> pairList : map.values()) {
            pairList.sort((a, b) -> a.getKey() - b.getKey());
            Set<String> set = new HashSet<>();
            for (int i = 0; i < pairList.size() - 2; i++) {
                for (int j = i + 1; j < pairList.size() - 1; j++) {
                    for (int k = j + 1; k < pairList.size(); k++) {
                        String pattern = pairList.get(i).getValue() + "_" + pairList.get(j).getValue() + "_" + pairList.get(k).getValue();
                        if (set.contains(pattern)) continue;
                        countMap.put(pattern, countMap.getOrDefault(pattern, 0) + 1);
                        set.add(pattern);
                        if (countMap.get(pattern) > maxCount) {
                            maxCount = countMap.get(pattern);
                            s = pattern;
                        } else if (countMap.get(pattern) == maxCount && pattern.compareTo(s) < 0) {
                            s = pattern;
                        }
                    }
                }
            }
        }
        return new ArrayList<>(Arrays.asList(s.split("_")));
    }
}
