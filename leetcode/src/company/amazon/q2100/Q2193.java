package company.amazon.q2100;

public class Q2193 {
    public int minMovesToMakePalindrome(String s) {
        int res = 0;
        StringBuilder builder = new StringBuilder(s);
        while (builder.length() > 2) {
            char c1 = builder.charAt(0);
            char c2 = builder.charAt(builder.length() - 1);
            int index1 = builder.lastIndexOf(String.valueOf(c1));
            int index2 = builder.indexOf(String.valueOf(c2));

            int length1 = builder.length() - 1 - index1;
            int length2 = index2;

            if (length1 < length2) {
                res += length1;
                builder.deleteCharAt(index1).deleteCharAt(0);
            } else {
                res += length2;
                builder.deleteCharAt(index2).deleteCharAt(builder.length() - 1);
            }
        }
        return res;
    }
}
