package company.bloomberg.goodluck;

import java.util.LinkedList;

public class Q390 {
    public int lastRemaining(int n) {
        int left = 1, right = n, steps = 1;
        boolean asc = true;
        while (left < right) {
            if (asc) {
                left += steps;
                steps *= 2;
                right = left + (right - left) / steps * steps;
            } else {
                right -= steps;
                steps *= 2;
                left = right - (right - left) / steps * steps;
            }
            asc = !asc;
        }
        return left;
    }
}
