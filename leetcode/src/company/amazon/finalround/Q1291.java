package company.amazon.finalround;

import java.util.ArrayList;
import java.util.List;

public class Q1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        String s = "123456789";
        int minLen = String.valueOf(low).length();
        int maxLen = String.valueOf(high).length();
        for (int i = minLen; i <= maxLen; i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                int val = Integer.parseInt(s.substring(j, j + i));
                if (val >= low && val <= high) res.add(val);
            }
        }
        return res;
    }
}
