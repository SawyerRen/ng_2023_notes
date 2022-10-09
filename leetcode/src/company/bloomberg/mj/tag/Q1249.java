package company.bloomberg.mj.tag;

public class Q1249 {
    public String minRemoveToMakeValid(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') right++;
        }
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (right > 0) {
                    builder.append(c);
                    right--;
                }
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    builder.append(c);
                    left--;
                } else {
                    right--;
                }
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
