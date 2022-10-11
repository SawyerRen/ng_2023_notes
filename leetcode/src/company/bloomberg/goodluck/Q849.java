package company.bloomberg.goodluck;

public class Q849 {
    public int maxDistToClosest(int[] seats) {
        int pre = -1, res = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                int d = pre == -1 ? i : (i - pre) / 2;
                pre = i;
                res = Math.max(res, d);
            }
        }
        res = Math.max(res, seats.length - 1 - pre);
        return res;
    }
}
