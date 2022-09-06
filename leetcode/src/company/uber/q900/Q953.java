package company.uber.q900;

public class Q953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!valid(words[i], words[i + 1], index)) return false;
        }
        return true;
    }

    private boolean valid(String s1, String s2, int[] index) {
        int len = Math.min(s1.length(), s2.length());
        for (int i = 0; i < len; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) return index[c1 - 'a'] < index[c2 - 'a'];
        }
        return s1.length() <= s2.length();
    }
}
