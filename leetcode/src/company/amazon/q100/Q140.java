package company.amazon.q100;

import java.util.*;

public class Q140 {
    Map<String, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return helper(s, wordSet);
    }

    private List<String> helper(String s, Set<String> wordSet) {
        if (map.containsKey(s)) return map.get(s);
        List<String> res = new ArrayList<>();
        if (s.equals("")) {
            res.add("");
            return res;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (wordSet.contains(s.substring(0, i))) {
                String pre = s.substring(0, i);
                List<String> nextList = helper(s.substring(i), wordSet);
                for (String next : nextList) {
                    if (next.equals("")) {
                        res.add(pre);
                    } else {
                        res.add(pre + " " + next);
                    }
                }
            }
        }
        map.put(s, res);
        return res;
    }

    public List<String> wordBreak1(String s, List<String> wordDict) {
        if (map.containsKey(s)) return map.get(s);
        List<String> res = new ArrayList<>();
        if (s.equals("")) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> nextList = wordBreak(s.substring(word.length()), wordDict);
                for (String next : nextList) {
                    if (next.equals("")) {
                        res.add(word);
                    } else {
                        res.add(word + " " + next);
                    }
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
