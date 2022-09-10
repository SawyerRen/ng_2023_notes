package company.amazon.q2000;

public class Q2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] leftCandle = new int[n];
        int[] rightCandle = new int[n];
        int[] candleCount = new int[n];
        int candleIndex = -1, count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                candleIndex = i;
                count++;
            }
            leftCandle[i] = candleIndex;
            candleCount[i] = count;
        }
        candleIndex = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                candleIndex = i;
            }
            rightCandle[i] = candleIndex;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            int left = rightCandle[queries[i][0]];
            int right = leftCandle[queries[i][1]];
            if (left >= right || left == -1 || right == -1) {
                res[i] = 0;
            } else {
                res[i] = right - left + 1 - (candleCount[right] - candleCount[left] + 1);
            }
        }
        return res;
    }
}
