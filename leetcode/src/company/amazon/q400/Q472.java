package company.amazon.q400;

import java.util.*;

public class Q472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Set<String> wordSet = new HashSet<>();
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
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
