package company.amazon.finalround;

import java.util.ArrayList;
import java.util.List;

public class Q93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s, 0, new StringBuilder());
        return res;
    }

    private void helper(List<String> res, String s, int partCount, StringBuilder builder) {
        if (partCount == 4) {
            if (s.isEmpty()) res.add(builder.toString());
            return;
        }
        int len = builder.length();
        for (int i = 1; i <= 3 && i <= s.length(); i++) {
            if (i > 1 && s.charAt(i) == '0') break;
            String sub = s.substring(0, i);
            int val = Integer.parseInt(sub);
            if (val <= 255) {
                if (len == 0) {
                    builder.append(sub);
                } else {
                    builder.append(".").append(sub);
                }
                helper(res, s.substring(i), partCount + 1, builder);
                builder.setLength(len);
            }
        }
    }
}
