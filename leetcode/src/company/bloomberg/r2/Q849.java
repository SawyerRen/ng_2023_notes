package company.bloomberg.r2;

public class Q849 {
    public int maxDistToClosest(int[] seats) {
        int res = 0, pre = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                int dist = pre == -1 ? i : (i - pre) / 2;
                res = Math.max(res, dist);
                pre = i;
            }
        }
        res = Math.max(res, seats.length - 1 - pre);
        return res;
    }
}
