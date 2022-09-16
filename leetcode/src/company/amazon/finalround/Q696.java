package company.amazon.finalround;

public class Q696 {
    public int countBinarySubstrings(String s) {
        int pre = 0, count = 1;
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                res += Math.min(pre, count);
                pre = count;
                count = 1;
            } else {
                count++;
            }
        }
        res += Math.min(pre, count);
        return res;
    }
}
