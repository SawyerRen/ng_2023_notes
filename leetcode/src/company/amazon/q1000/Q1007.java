package company.amazon.q1000;

public class Q1007 {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] countA = new int[7], countB = new int[7];
        int[] same = new int[7];
        for (int i = 0; i < tops.length; i++) {
            countA[tops[i]]++;
            countB[bottoms[i]]++;
            if (tops[i] == bottoms[i]) same[tops[i]]++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < 7; i++) {
            if (countA[i] + countB[i] - same[i] == tops.length) {
                res = Math.min(res, tops.length - Math.max(countA[i], countB[i]));
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
