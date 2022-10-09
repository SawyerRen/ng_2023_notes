package company.bloomberg.r2;

public class Q1358 {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int i = 0, j = 0, res = 0;
        while (j < s.length()) {
            count[s.charAt(j) - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[s.charAt(i) - 'a']--;
                i++;
            }
            res += i;
            j++;
        }
        return res;
    }
}
