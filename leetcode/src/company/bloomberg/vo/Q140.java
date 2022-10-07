package company.bloomberg.vo;

import java.util.*;

public class Q140 {
    Map<String, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return helper(s, wordSet);
    }

    private List<String> helper(String s, Set<String> wordSet) {
        if (memo.containsKey(s)) return memo.get(s);
        List<String> res = new ArrayList<>();
        if (s.equals("")) {
            res.add("");
            return res;
        }
        for (int i = 1; i <= s.length(); i++) {
            String pre = s.substring(0, i);
            if (wordSet.contains(pre)) {
                String next = s.substring(i);
                List<String> nextList = helper(next, wordSet);
                for (String s1 : nextList) {
                    if (s1.equals("")) {
                        res.add(pre);
                    } else {
                        res.add(pre + " " + s1);
                    }
                }
            }
        }
        memo.put(s, res);
        return res;
    }

    public List<String> wordBreak1(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s.equals("")) {
            res.add("");
            return res;
        }
        if (memo.containsKey(s)) return memo.get(s);
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> nextList = wordBreak1(s.substring(word.length()), wordDict);
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
