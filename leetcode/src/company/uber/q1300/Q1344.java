package company.uber.q1300;

public class Q1344 {
    public double angleClock(int hour, int minutes) {
        double m = minutes * 6;
        double h = hour * 30 + minutes * 30.0 / 60;
        double angle = Math.abs(m - h);
        return Math.min(angle, 360 - angle);
    }
}
