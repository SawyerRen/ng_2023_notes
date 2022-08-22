package company.bloomberg.q1200;

public class Q1274 {
    class Sea {
        public boolean hasShips(int[] topRight, int[] bottomLeft) {
            return false;
        }
    }

    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if (topRight[0] < bottomLeft[0] || topRight[1] < bottomLeft[1]) return 0;
        if (!sea.hasShips(topRight, bottomLeft)) return 0;
        if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) return 1;
        int i = bottomLeft[0] + (topRight[0] - bottomLeft[0]) / 2;
        int j = bottomLeft[1] + (topRight[1] - bottomLeft[1]) / 2;
        return countShips(sea, topRight, new int[]{i + 1, j + 1})
                + countShips(sea, new int[]{i, j}, bottomLeft)
                + countShips(sea, new int[]{topRight[0], j}, new int[]{i + 1, bottomLeft[1]})
                + countShips(sea, new int[]{i, topRight[1]}, new int[]{bottomLeft[0], j + 1});
    }
}
