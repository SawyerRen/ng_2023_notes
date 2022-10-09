package company.bloomberg.r2;

import java.util.HashSet;
import java.util.Set;

public class Q888 {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < aliceSizes.length; i++) {
            sumA += aliceSizes[i];
            set.add(aliceSizes[i]);
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
