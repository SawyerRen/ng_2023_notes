package company.uber.all1;

public class Q424 {
    public int characterReplacement(String s, int k) {
        int i = 0, j = 0, res = 0;
        int maxCount = 0;
        int[] count = new int[26];
        while (j < s.length()) {
            char rc = s.charAt(j);
            count[rc - 'A']++;
            maxCount = Math.max(maxCount, count[rc - 'A']);
            while (maxCount + k < j - i + 1) {
                char lc = s.charAt(i);
                count[lc - 'A']--;
                for (int c : count) {
                    maxCount = Math.max(maxCount, c);
                }
                i++;
            }
            res = Math.max(j - i + 1, res);
            j++;
        }
        return res;
    }
}
