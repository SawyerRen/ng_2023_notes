package company.uber.lastround;

import java.util.*;

public class Q269 {
    public String alienOrder(String[] words) {
        Map<Character, Integer> preCount = new HashMap<>();
        Map<Character, Set<Character>> map = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                preCount.put(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i], s2 = words[i + 1];
            if (s1.length() > s2.length() && s1.startsWith(s2)) return "";
            for (int j = 0; j < Math.min(s1.length(), s2.length()); j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if (c1 != c2) {
                    map.putIfAbsent(c1, new HashSet<>());
                    if (!map.get(c1).contains(c2)) {
                        preCount.put(c2, preCount.get(c2) + 1);
                        map.get(c1).add(c2);
                    }
                    break;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (Character c : preCount.keySet()) {
            if (preCount.get(c) == 0) queue.add(c);
        }
        while (!queue.isEmpty()) {
            Character c1 = queue.poll();
            builder.append(c1);
            if (map.containsKey(c1)) {
                for (Character c2 : map.get(c1)) {
                    preCount.put(c2, preCount.get(c2) - 1);
                    if (preCount.get(c2) == 0) queue.add(c2);
                }
            }
        }
        if (builder.length() == preCount.size()) return builder.toString();
        return "";
    }
}
