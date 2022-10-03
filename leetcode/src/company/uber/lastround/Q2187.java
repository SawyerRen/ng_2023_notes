package company.uber.lastround;

public class Q2187 {
    public long minimumTime(int[] time, int totalTrips) {
        long max = 0;
        for (int i : time) {
            max = Math.max(max, i);
        }
        long left = 0, right = max * totalTrips + 1;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long count = 0;
            for (int i : time) {
                count += mid / i;
            }
            if (count >= totalTrips) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
