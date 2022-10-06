package company.bloomberg.all.q400;

public class Q443 {
    public int compress(char[] chars) {
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int count = 1;
            while (i + 1 < chars.length && chars[i + 1] == c) {
                count++;
                i++;
            }
            chars[index++] = c;
            if (count > 1) {
                for (char c1 : String.valueOf(count).toCharArray()) {
                    chars[index++] = c1;
                }
            }
        }
        return index;
    }
}
