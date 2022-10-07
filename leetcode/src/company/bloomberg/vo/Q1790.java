package company.bloomberg.vo;

public class Q1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] count = new int[26];
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) diff++;
            count[c1 - 'a']++;
            count[c2 - 'a']--;
        }
        for (int i : count) {
            if (i != 0) return false;
        }
        return diff <= 2;
    }
}
