package company.uber.q200;

import java.util.ArrayList;
import java.util.List;

public class Q267 {
    public List<String> generatePalindromes(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        Character oddChar = null;
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 != 0) {
                if (oddChar != null) return new ArrayList<>();
                oddChar = (char) (i + 'a');
            }
        }
        String center = "";
        if (oddChar != null) {
            center = String.valueOf(oddChar);
            count[oddChar - 'a']--;
        }
        List<String> res = new ArrayList<>();
        helper(res, center, count, s.length());
        return res;
    }

    private void helper(List<String> res, String s, int[] count, int length) {
        if (s.length() == length) {
            res.add(s);
            return;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                count[i] -= 2;
                char c = (char) (i + 'a');
                helper(res, c + s + c, count, length);
                count[i] += 2;
            }
        }
    }
}
