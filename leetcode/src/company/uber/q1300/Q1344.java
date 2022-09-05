package company.uber.q1300;

public class Q1344 {
    public double angleClock(int hour, int minutes) {
        double h = 30 * hour + 30 * (minutes / 60.0);
        double m = 360 * (minutes / 60.0);
        double angle = Math.abs(m - h);
        return Math.min(angle, 360 - angle);
    }
}
