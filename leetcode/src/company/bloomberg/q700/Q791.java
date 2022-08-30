package company.bloomberg.q700;

public class Q791 {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (char c : order.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; i++) {
                builder.append(c);
            }
            count[c - 'a'] = 0;
        }
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                builder.append((char) (i + 'a'));
            }
        }
        return builder.toString();
    }
}
