package company.bloomberg.vo;

public class Q849 {
    public int maxDistToClosest(int[] seats) {
        int res = 0, last = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (last == -1) {
                    res = i;
                } else {
                    res = Math.max(res, (i - last) / 2);
                }
                last = i;
            }
        }
        res = Math.max(res, seats.length - 1 - last);
        return res;
    }
}
