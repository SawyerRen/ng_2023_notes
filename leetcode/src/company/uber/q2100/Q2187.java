package company.uber.q2100;

public class Q2187 {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 0, right = 0;
        for (int i : time) {
            right = Math.max(right, i);
        }
        right = right * totalTrips + 1;
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
