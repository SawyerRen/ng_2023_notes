package company.bloomberg.vo;

public class Q392 {
    public boolean isSubsequence(String s, String t) {
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (index < s.length() && t.charAt(i) == s.charAt(index)) {
                index++;
            }
        }
        return index == s.length();
    }
}
