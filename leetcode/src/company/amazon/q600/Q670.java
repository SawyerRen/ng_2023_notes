package company.amazon.q600;

public class Q670 {
    public int maximumSwap(int num) {
        int[] lastIndex = new int[10];
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            lastIndex[chars[i] - '0'] = i;
        }
        for (int i = 0; i < chars.length; i++) {
            for (int j = 9; j > chars[i] - '0'; j--) {
                int index = lastIndex[j];
                if (index > i) {
                    char c = chars[index];
                    chars[index] = chars[i];
                    chars[i] = c;
                    return Integer.parseInt(String.valueOf(chars));
                }
            }
        }
        return num;
    }
}
