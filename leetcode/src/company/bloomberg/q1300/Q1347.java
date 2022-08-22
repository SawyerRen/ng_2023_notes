package company.bloomberg.q1300;

public class Q1347 {
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        int res = 0;
        for (int i : count) {
            res += Math.abs(i);
        }
        return res / 2;
    }
}
