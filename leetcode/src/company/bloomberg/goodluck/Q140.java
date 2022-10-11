package company.bloomberg.goodluck;

import java.util.*;

public class Q140 {
    Map<String, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return helper(s, set);
    }

    private List<String> helper(String s, Set<String> set) {
        if (memo.containsKey(s)) return memo.get(s);
        List<String> res = new ArrayList<>();
        if (s.equals("")) {
            res.add("");
            return res;
        }
        for (int i = 0; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (set.contains(sub)) {
                List<String> nextList = helper(s.substring(i), set);
                for (String next : nextList) {
                    if (next.equals("")) {
                        res.add(sub);
                    } else {
                        res.add(sub + " " + next);
                    }
                }
            }
        }
        memo.put(s, res);
        return res;
    }

    public List<String> wordBreak1(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (memo.containsKey(s)) return memo.get(s);
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
        memo.put(s, res);
        return res;
    }
}
