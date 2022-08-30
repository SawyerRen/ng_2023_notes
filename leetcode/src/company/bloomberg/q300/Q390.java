package company.bloomberg.q300;

public class Q390 {
    public int lastRemaining(int n) {
        boolean asc = true;
        int left = 1, right = n;
        int inc = 1;
        while (left < right) {
            if (asc) {
                left += inc;
                inc *= 2;
                right = left + (right - left) / inc * inc;
            } else {
                right -= inc;
                inc *= 2;
                left = right - (right - left) / inc * inc;
            }
            asc = !asc;
        }
        return left;
    }
}
