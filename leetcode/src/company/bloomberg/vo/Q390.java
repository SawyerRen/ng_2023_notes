package company.bloomberg.vo;

public class Q390 {
    public int lastRemaining(int n) {
        int left = 1, right = n, inc = 1;
        boolean rev = false;
        while (left < right) {
            if (!rev) {
                left += inc;
                inc *= 2;
                right = left + (right - left) / inc * inc;
            } else {
                right -= inc;
                inc *= 2;
                left = right - (right - left) / inc * inc;
            }
            rev = !rev;
        }
        return left;
    }
}
