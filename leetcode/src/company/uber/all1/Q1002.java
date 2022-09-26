package company.uber.all1;

import java.util.ArrayList;
import java.util.List;

public class Q1002 {
    public List<String> commonChars(String[] words) {
        int[][] count = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                count[i][c - 'a']++;
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int min = count[0][i];
            for (int j = 0; j < words.length; j++) {
                min = Math.min(min, count[j][i]);
            }
            for (int j = 0; j < min; j++) {
                res.add(String.valueOf((char) (i + 'a')));
            }
        }
        return res;
    }
}
