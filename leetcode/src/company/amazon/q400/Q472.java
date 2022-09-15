package company.amazon.q400;

import java.util.*;

public class Q472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Set<String> wordSet = new HashSet<>();
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (canForm(word, wordSet)) {
                res.add(word);
            }
            wordSet.add(word);
        }
        return res;
    }

    private boolean canForm(String word, Set<String> wordSet) {
        int n = word.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    private List<String> getFormList(String word, Set<String> wordSet) {
        List<String> list = new ArrayList<>();
        if (word.isEmpty()) {
            list.add("");
            return list;
        }
        for (String s : wordSet) {
            if (word.startsWith(s)) {
                List<String> nextList = getFormList(word.substring(s.length()), wordSet);
                if (!nextList.isEmpty()) {
                    for (String next : nextList) {
                        if (next.equals("")) {
                            list.add(s);
                        } else {
                            list.add(0, s);
                        }
                        return list;
                    }
                }
            }
        }
        return list;
    }
}
