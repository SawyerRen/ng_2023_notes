package company.uber.all2;

public class Q424 {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int i = 0, j = 0, maxCount = 0;
        int res = 0;
        while (j < s.length()) {
            char rc = s.charAt(j);
            count[rc - 'A']++;
            maxCount = Math.max(count[rc - 'A'], maxCount);
            while (j - i + 1 > maxCount + k) {
                char lc = s.charAt(i);
                count[lc - 'A']--;
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
