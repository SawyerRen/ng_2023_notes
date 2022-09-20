package company.expedia.oa;

public class MaxEvenSum {
    int solution(int[] arr) {
        int posSum = 0;
        for (int i : arr) {
            if (i > 0) posSum += i;
        }
        if (posSum % 2 == 0) return posSum;
        int n1 = Integer.MIN_VALUE, n2 = Integer.MAX_VALUE;
        for (int i : arr) {
            if (i % 2 != 0) {
                if (i > 0) {
                    n2 = Math.min(n2, i);
                } else {
                    n1 = Math.max(n1, i);
                }
            }
        }
        return Math.max(posSum - n2, posSum + n1);
    }
}
