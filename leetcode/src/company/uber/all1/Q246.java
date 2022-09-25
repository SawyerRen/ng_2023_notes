package company.uber.all1;

import java.util.HashMap;
import java.util.Map;

public class Q246 {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
        int i = 0, j = num.length()-1;
        while (i <= j) {
            char c1 = num.charAt(i);
            char c2 = num.charAt(j);
            if (!map.containsKey(c1) || map.get(c1) != c2) return false;
            i++;
            j--;
        }
        return true;
    }
}
