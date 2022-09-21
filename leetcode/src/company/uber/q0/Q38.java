package company.uber.q0;

public class Q38 {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String pre = countAndSay(n - 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < pre.length(); i++) {
            char c = pre.charAt(i);
            int count = 1;
            while (i + 1 < pre.length() && pre.charAt(i + 1) == c) {
                i++;
                count++;
            }
            builder.append(count).append(c);
        }
        return builder.toString();
    }
}
