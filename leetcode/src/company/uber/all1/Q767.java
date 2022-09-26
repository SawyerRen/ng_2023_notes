package company.uber.all1;

public class Q767 {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        int maxCount = 0;
        char maxChar = 'a';
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
            if (count[c - 'a'] > maxCount) {
                maxCount = Math.max(maxCount, count[c - 'a']);
                maxChar = c;
            }
        }
        if (maxCount * 2 > s.length() + 1) return "";
        char[] chars = new char[s.length()];
        int index = 0;
        while (count[maxChar - 'a'] > 0) {
            chars[index] = maxChar;
            index += 2;
            count[maxChar - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                if (index >= s.length()) index = 1;
                chars[index] = (char) (i + 'a');
                index += 2;
                count[i]--;
            }
        }
        return new String(chars);
    }
}
