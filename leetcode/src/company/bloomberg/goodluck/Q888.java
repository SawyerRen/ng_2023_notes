package company.bloomberg.goodluck;

import java.util.HashSet;
import java.util.Set;

public class Q888 {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        Set<Integer> set = new HashSet<>();
        int sumA = 0, sumB = 0;
        for (int aliceSize : aliceSizes) {
            set.add(aliceSize);
            sumA += aliceSize;
        }
        for (int bobSize : bobSizes) {
            sumB += bobSize;
        }
        int diff = (sumA - sumB) / 2;
        for (int bobSize : bobSizes) {
            if (set.contains(bobSize + diff)) {
                return new int[]{bobSize + diff, bobSize};
            }
        }
        return new int[2];
    }
}
