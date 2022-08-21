package company.amazon.q2200;

public class Q2214 {
    public long minimumHealth(int[] damage, int armor) {
        long sum = 0;
        int max = 0;
        for (int i : damage) {
            sum += i;
            max = Math.max(max, i);
        }
        return sum + 1 - Math.min(max, armor);
    }
}
