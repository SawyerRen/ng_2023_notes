package company.uber.lastround;

public class Q1344 {
    public double angleClock(int hour, int minutes) {
        double m = minutes * 6;
        double h = 30 * hour + minutes * 0.5;
        double angle = Math.abs(m - h);
        if (angle > 180) angle = 360 - angle;
        return angle;
    }
}
