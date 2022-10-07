package company.bloomberg.vo;

import java.util.ArrayList;
import java.util.List;

public class Q1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
        int minLen = String.valueOf(low).length();
        int maxLen = String.valueOf(high).length();
        List<Integer> res = new ArrayList<>();
        for (int len = minLen; len < maxLen + 1; len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int val = Integer.parseInt(s.substring(i, i + len));
                if (val >= low && val <= high) {
                    res.add(val);
                }
            }
        }
        return res;
    }
}
