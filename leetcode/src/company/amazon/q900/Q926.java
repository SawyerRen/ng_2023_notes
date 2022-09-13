package company.amazon.q900;

public class Q926 {
    public int minFlipsMonoIncr(String s) {
        int flip = 0, count1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count1++;
            } else {
                flip = Math.min(flip + 1, count1);
            }
        }
        return flip;
    }
}
