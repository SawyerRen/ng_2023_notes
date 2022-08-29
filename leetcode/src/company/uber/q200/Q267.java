package company.uber.q200;

import java.util.ArrayList;
import java.util.List;

public class Q267 {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int oddCount = 0;
        char oddChar = 'a';
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                oddChar = (char) (i + 'a');
            }
        }
        if (oddCount > 1) return res;
        if (oddCount == 1) count[oddChar - 'a']--;
        String pal = oddCount == 0 ? "" : String.valueOf(oddChar);
        helper(res, pal, count, s.length());
        return res;
    }

    private void helper(List<String> res, String pal, int[] count, int len) {
        if (len == pal.length()) {
            res.add(pal);
            return;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) continue;
            char c = (char) (i + 'a');
            count[i] -= 2;
            helper(res, c + pal + c, count, len);
            count[i] += 2;
        }
    }
}
