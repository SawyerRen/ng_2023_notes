package company.bloomberg.mj.nontag;

import java.util.Arrays;

public class StableMarriage {
    static void stableMarriage(int[][] mPrefer, int[][] wPrefer, int n) {
        int[] wPartner = new int[n];
        boolean[] mFree = new boolean[n];
        Arrays.fill(mFree, true);
        Arrays.fill(wPartner, -1);
        int freeCount = n;

        while (freeCount > 0) {
            for (int m = 0; m < n; m++) {
                if (!mFree[m]) continue;
                for (int i = 0; i < n && mFree[m]; i++) {
                    int w = mPrefer[m][i];
                    if (wPartner[w] == -1) {
                        wPartner[w] = m;
                        mFree[m] = false;
                        freeCount--;
                    } else {
                        int m1 = wPartner[w];
                        if (preferOver(wPrefer, w, m, m1)) {
                            wPartner[w] = m;
                            mFree[m] = false;
                            mFree[m1] = true;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(i + "    " + wPartner[i]);
        }
    }

    private static boolean preferOver(int[][] wPrefer, int w, int m, int m1) {
        for (int i = 0; i < wPrefer.length; i++) {
            if (wPrefer[w][i] == m) return true;
            if (wPrefer[w][i] == m1) return false;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mPrefer = {{3, 1, 2, 0}, {1, 0, 2, 3}, {0, 1, 2, 3}, {0, 1, 2, 3}};
        int[][] wPrefer = {{0, 1, 2, 3}, {0, 1, 2, 3}, {0, 1, 2, 3}, {0, 1, 2, 3}};
        stableMarriage(mPrefer, wPrefer, mPrefer.length);
    }
}
