package company.amazon.q2200;

public class Q2272 {
    public int largestVariance(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j || count[i] == 0 || count[j] == 0) continue;
                int countA = 0, countB = 0;
                int remainA = count[i];
                for (char c : s.toCharArray()) {
                    if (i == c - 'a') {
                        countA++;
                        remainA--;
                    } else if (j == c - 'a') countB++;
                    if (countB < countA && remainA > 0) {
                        countA = countB = 0;
                    }
                    if (countA > 0 && countB > 0) {
                        res = Math.max(res, countB - countA);
                    }
                }
            }
        }
        return res;
    }
}
