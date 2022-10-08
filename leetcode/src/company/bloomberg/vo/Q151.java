package company.bloomberg.vo;

public class Q151 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') continue;
            int left = i, right = i;
            while (right + 1 < chars.length && chars[right + 1] != ' ') right++;
            reverse(chars, left, right);
            i = right;
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
            i++;
            j--;
        }
    }
}
