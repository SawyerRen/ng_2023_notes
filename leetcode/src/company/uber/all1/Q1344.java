package company.uber.all1;

public class Q1344 {
    public double angleClock(int hour, int minutes) {
        double m = minutes * 6;
        double h = hour * 30 + minutes * 0.5;
        double res = Math.abs(m - h);
        return Math.min(res, 360 - res);
    }
}
