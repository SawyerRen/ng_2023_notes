package company.uber.lastround;

import java.util.HashMap;
import java.util.Map;

public class Q149 {
    public int maxPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int max = 0, duplicate = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int diffX = points[j][0] - points[i][0];
                int diffY = points[j][1] - points[i][1];
                if (diffX == 0 && diffY == 0) {
                    duplicate++;
                    continue;
                }
                int gcd = helper(diffX, diffY);
                diffY /= gcd;
                diffX /= gcd;
                String s = diffY + "/" + diffX;
                map.put(s, map.getOrDefault(s, 0) + 1);
                max = Math.max(max, map.get(s));
            }
            res = Math.max(res, duplicate + max + 1);
        }
        return res;
    }

    private int helper(int a, int b) {
        if (b == 0) return a;
        return helper(b, a % b);
    }
}
