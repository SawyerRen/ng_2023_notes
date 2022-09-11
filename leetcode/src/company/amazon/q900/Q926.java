package company.amazon.q900;

public class Q926 {
    public int minFlipsMonoIncr(String s) {
        int flips = 0, count1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count1++;
            } else {
                flips = Math.min(flips + 1, count1);
            }
        }
        return flips;
    }
}
