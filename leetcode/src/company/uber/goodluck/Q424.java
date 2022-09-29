package company.uber.goodluck;

public class Q424 {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int i = 0, j = 0, res = 0;
        int maxCount = 0;
        while (j < s.length()) {
            char c1 = s.charAt(j);
            count[c1 - 'A']++;
            maxCount = Math.max(maxCount, count[c1 - 'A']);
            while (j - i + 1 > maxCount + k) {
                char c2 = s.charAt(i);
                count[c2 - 'A']--;
                for (int num : count) {
                    maxCount = Math.max(maxCount, num);
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
