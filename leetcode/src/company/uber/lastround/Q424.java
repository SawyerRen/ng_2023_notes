package company.uber.lastround;

public class Q424 {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int i = 0, j = 0, res = 0;
        int maxCount = 0;
        while (j < s.length()) {
            char rc = s.charAt(j);
            count[rc - 'A']++;
            maxCount = Math.max(maxCount, count[rc - 'A']);
            while (maxCount + k < j - i + 1) {
                count[s.charAt(i) - 'A']--;
                for (int i1 : count) {
                    maxCount = Math.max(maxCount, i1);
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
