package company.uber.q100;

import java.util.HashMap;
import java.util.Map;

public class Q140 {
    public int maxPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int duplicate = 0, max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int diffX = points[i][0] - points[j][0];
                int diffY = points[i][1] - points[j][1];
                if (diffX == 0 && diffY == 0) {
                    duplicate++;
                    continue;
                }
                int gcd = findGCD(diffX, diffY);
                diffX /= gcd;
                diffY /= gcd;
                String slope = diffX + "/" + diffY;
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                max = Math.max(max, map.get(slope));
            }
            res = Math.max(res, 1 + duplicate + max);
        }
        return res;
    }

    private int findGCD(int a, int b) {
        if (b == 0) return a;
        return findGCD(b, a % b);
    }
}
