package company.uber.q200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q247 {
    public List<String> findStrobogrammatic(int n) {
        Map<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('0', '0');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
        List<String> res = new ArrayList<>();
        char[] chars = new char[n];
        helper(res, chars, 0, n - 1, map);
        return res;
    }

    private void helper(List<String> res, char[] chars, int left, int right, Map<Character, Character> map) {
        if (left > right) {
            res.add(String.valueOf(chars));
            return;
        }
        for (Character c1 : map.keySet()) {
            if (left == right && (c1 == '6' || c1 == '9')) continue;
            if (left == 0 && left < right && c1 == '0') continue;
            chars[left] = c1;
            chars[right] = map.get(c1);
            helper(res, chars, left + 1, right - 1, map);
        }
    }
}
