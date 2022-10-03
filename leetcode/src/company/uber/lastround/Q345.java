package company.uber.lastround;

import java.util.HashSet;
import java.util.Set;

public class Q345 {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            while (i < j && !set.contains(s.charAt(i))) i++;
            while (i < j && !set.contains(s.charAt(j))) j--;
            if (i < j) {
                char c = chars[i];
                chars[i] = chars[j];
                chars[j] = c;
                i++;
                j--;
            }
        }
        return new String(chars);
    }
}
