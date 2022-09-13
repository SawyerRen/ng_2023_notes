package company.amazon.q600;

public class Q696 {
    public int countBinarySubstrings(String s) {
        int cur = 1, pre = 0;
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) cur++;
            else {
                res += Math.min(cur, pre);
                pre = cur;
                cur = 1;
            }
        }
        res += Math.min(cur, pre);
        return res;
    }
}
