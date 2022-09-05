package company.uber.q900;

import java.util.HashMap;
import java.util.Map;

public class Q953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderArr = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderArr[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!valid(words[i], words[i + 1], orderArr)) return false;
        }
        return true;
    }

    private boolean valid(String word1, String word2, int[] order) {
        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            if (c1 != c2) return order[c1 - 'a'] < order[c2 - 'a'];
        }
        return word1.length() <= word2.length();
    }
}
