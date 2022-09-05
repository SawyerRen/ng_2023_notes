package company.uber.q400;

public class Q424 {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int i = 0, j = 0, maxCount = 0;
        int res = 0;
        while (j < s.length()) {
            count[s.charAt(j) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(j) - 'A']);
            if (j - i + 1 - maxCount > k) {
                count[s.charAt(i) - 'A']--;
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
