package company.amazon.q2200;

public class Q2272 {
    public int largestVariance(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j || freq[i] == 0 || freq[j] == 0) continue;
                int count1 = 0, count2 = 0;
                int remain1 = freq[i];
                for (char c : s.toCharArray()) {
                    if (i == c - 'a') {
                        count1++;
                        remain1--;
                    } else if (j == c - 'a') count2++;
                    if (count1 > 0 && count2 > 0) res = Math.max(res, count2 - count1);
                    if (count1 > count2 && remain1 > 0) {
                        count1 = count2 = 0;
                    }
                }
            }
        }
        return res;
    }
}
