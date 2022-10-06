package company.bloomberg.all.q100;

public class Q151 {
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] != ' ') {
                int j = i;
                while (j + 1 < chars.length && chars[j + 1] != ' ') {
                    j++;
                }
                reverse(chars, i, j);
                i = j;
            }
        }
        return new String(chars);
    }

    private static void reverse(char[] chars, int l, int r) {
        while (l < r) {
            char c = chars[l];
            chars[l] = chars[r];
            chars[r] = c;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }
}
