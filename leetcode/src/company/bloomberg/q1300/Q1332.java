package company.bloomberg.q1300;

public class Q1332 {
    public int removePalindromeSub(String s) {
        if (s.isEmpty()) return 0;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return 2;
            i++;
            j--;
        }
        return 1;
    }
}
