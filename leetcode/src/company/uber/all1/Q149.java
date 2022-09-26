package company.uber.all1;

import java.util.HashMap;
import java.util.Map;

public class Q149 {
    public int maxPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int duplicate = 0, max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int diffY = points[j][1] - points[i][1];
                int diffX = points[j][0] - points[i][0];
                if (diffX == 0 && diffY == 0) {
                    duplicate++;
                    continue;
                }
                int gcd = helper(diffX, diffY);
                diffY /= gcd;
                diffX /= gcd;
                String slope = diffY + "/" + diffX;
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                max = Math.max(max, map.get(slope));
            }
            res = Math.max(res, max + duplicate + 1);
        }
        return res;
    }

    private int helper(int a, int b) {
        if (b == 0) return a;
        return helper(b, a % b);
    }
}
