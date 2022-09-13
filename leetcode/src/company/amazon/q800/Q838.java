package company.amazon.q800;

public class Q838 {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int lastRight = -1;
        char[] chars = dominoes.toCharArray();
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'L') lastRight = -1;
            else if (chars[i] == 'R') lastRight = i;
            else right[i] = lastRight != -1 ? i - lastRight : 0;
        }
        int lastLeft = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (chars[i] == 'L') lastLeft = i;
            else if (chars[i] == 'R') lastLeft = -1;
            else left[i] = lastLeft != -1 ? lastLeft - i : 0;
        }
        char[] res = new char[n];
        for (int i = 0; i < res.length; i++) {
            if (chars[i] == 'L') res[i] = 'L';
            else if (chars[i] == 'R') res[i] = 'R';
            else {
                if (left[i] == 0 && right[i] != 0) res[i] = 'R';
                else if (left[i] != 0 && right[i] == 0) res[i] = 'L';
                else if (left[i] > right[i]) res[i] = 'R';
                else if (left[i] < right[i]) res[i] = 'L';
                else res[i] = '.';
            }
        }
        return String.valueOf(res);
    }
}
