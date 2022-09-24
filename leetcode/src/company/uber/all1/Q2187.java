package company.uber.all1;

public class Q2187 {
    public long minimumTime(int[] time, int totalTrips) {
        long max = time[0];
        for (int t : time) {
            max = Math.max(t, max);
        }
        long left = 1, right = max * totalTrips + 1;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long count = 0;
            for (int t : time) {
                count += mid / t;
            }
            if (count >= totalTrips) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
