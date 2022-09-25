package company.uber.all1;

public class Q953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] arr = new int[26];
        for (int i = 0; i < order.length(); i++) {
            arr[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!valid(arr, words[i], words[i + 1])) return false;
        }
        return true;
    }

    private boolean valid(int[] order, String s1, String s2) {
        int min = Math.min(s1.length(), s2.length());
        for (int i = 0; i < min; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) return order[c1 - 'a'] < order[c2 - 'a'];
        }
        return s1.length() <= s2.length();
    }
}
