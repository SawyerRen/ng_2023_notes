package company.uber.q400;

public class Q424 {
    public int characterReplacement(String s, int k) {
        int i = 0, j = 0, res = 0;
        int[] count = new int[26];
        int maxCount = 0;
        while (j < s.length()) {
            count[s.charAt(j) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(j) - 'A']);
            while (maxCount + k < j - i + 1) {
                count[s.charAt(i) - 'A']--;
                for (int c : count) {
                    maxCount = Math.max(maxCount, c);
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
