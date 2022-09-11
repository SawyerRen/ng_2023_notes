package company.amazon.q1200;

import java.util.ArrayList;
import java.util.List;

public class Q1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
        List<Integer> res = new ArrayList<>();
        int minLen = String.valueOf(low).length();
        int maxLen = String.valueOf(high).length();
        for (int len = minLen; len <= maxLen; len++) {
            for (int left = 0; left + len <= s.length(); left++) {
                int num = Integer.parseInt(s.substring(left, left + len));
                if (low <= num && num <= high) res.add(num);
            }
        }
        return res;
    }
}
