package company.bloomberg.q1700;

public class Q1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] count = new int[26];
        if (s1.length() != s2.length()) return false;
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) diff++;
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int i : count) {
            if (i != 0) return false;
        }
        return diff <= 2;
    }
}
