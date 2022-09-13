package company.amazon.q200;

public class Q277 {
    boolean knows(int a, int b) {
        return true;
    }

    public int findCelebrity(int n) {
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (knows(res, i)) res = i;
        }
        for (int i = 0; i < n; i++) {
            if (res != i && (!knows(i, res) || knows(res, i))) return -1;
        }
        return res;
    }
}
