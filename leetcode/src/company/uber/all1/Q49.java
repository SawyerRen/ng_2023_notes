package company.uber.all1;

import java.util.*;

public class Q49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            String pattern = Arrays.toString(count);
            map.putIfAbsent(pattern, new ArrayList<>());
            map.get(pattern).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
