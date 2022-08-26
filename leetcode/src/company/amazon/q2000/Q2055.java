package company.amazon.q2000;

import java.util.Arrays;
import java.util.TreeMap;

public class Q2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] rightCandle = new int[n];
        int[] leftCandle = new int[n];
        int[] candleCount = new int[n];
        int candle = -1;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                candle = i;
                sum++;
            }
            leftCandle[i] = candle;
            candleCount[i] = sum;
        }
        candle = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                candle = i;
            }
            rightCandle[i] = candle;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = rightCandle[queries[i][0]];
            int right = leftCandle[queries[i][1]];
            if (left == -1 || right == -1 || left >= right) {
                res[i] = 0;
            } else {
                res[i] = right - left + 1 - (candleCount[right] - candleCount[left] + 1);
            }
        }
        return res;
    }

    public int[] platesBetweenCandles1(String s, int[][] queries) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                map.put(i, count++);
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            Integer index1 = map.ceilingKey(queries[i][0]);
            Integer index2 = map.floorKey(queries[i][1]);
            if (index1 == null || index2 == null || index1 >= index2) continue;
            int place1 = map.get(index1);
            int place2 = map.get(index2);
            res[i] = (index2 - index1) - (place2 - place1);
        }
        return res;
    }
}
