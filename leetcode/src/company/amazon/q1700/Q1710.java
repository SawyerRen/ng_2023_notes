package company.amazon.q1700;

import java.util.Arrays;

public class Q1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int res = 0;
        for (int[] boxType : boxTypes) {
            if (truckSize == 0) break;
            if (truckSize > boxType[0]) {
                res += boxType[0] * boxType[1];
                truckSize -= boxType[0];
            } else {
                res += truckSize * boxType[1];
                truckSize = 0;
            }
        }
        return res;
    }
}
