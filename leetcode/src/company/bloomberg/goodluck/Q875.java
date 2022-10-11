package company.bloomberg.goodluck;

public class Q875 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile) + 1;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int need = 0;
            for (int pile : piles) {
                need += (pile - 1) / mid + 1;
            }
            if (need <= h) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
