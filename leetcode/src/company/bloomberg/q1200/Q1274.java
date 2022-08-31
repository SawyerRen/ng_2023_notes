package company.bloomberg.q1200;

public class Q1274 {
    interface Sea {
        public boolean hasShips(int[] topRight, int[] bottomLeft);
    }

    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if (topRight[0] < bottomLeft[0] || topRight[1] < bottomLeft[1]) return 0;
        if (!sea.hasShips(topRight, bottomLeft)) return 0;
        if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) return 1;
        int x = (bottomLeft[0] + topRight[0]) / 2;
        int y = (bottomLeft[1] + topRight[1]) / 2;
        return countShips(sea, topRight, new int[]{x + 1, y + 1})
                + countShips(sea, new int[]{x, y}, bottomLeft)
                + countShips(sea, new int[]{x, topRight[1]}, new int[]{bottomLeft[0], y + 1})
                + countShips(sea, new int[]{topRight[0], y}, new int[]{x + 1, bottomLeft[1]});
    }
}
