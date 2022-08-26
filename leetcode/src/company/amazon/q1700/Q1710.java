package company.amazon.q1700;

import java.util.Arrays;

public class Q1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int res = 0;
        for (int[] boxType : boxTypes) {
            if (truckSize == 0) break;
            while (truckSize > 0 && boxType[0] > 0) {
                res += boxType[1];
                boxType[0]--;
                truckSize--;
            }
        }
        return res;
    }
}
