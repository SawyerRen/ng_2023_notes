package company.expedia.oa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComplementaryPairs {
    static long solution(String[] list) {
        long res = 0;
        Map<String, Long> map = new HashMap<>();
        for (String s : list) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a'] = (count[c - 'a'] + 1) % 2;
            }
            String c = Arrays.toString(count);
            System.out.println(c);
            res += map.getOrDefault(c, 0L);
            System.out.println(res);
            for (int i = 0; i < 26; i++) {
                int[] temp = count.clone();
                temp[i] = temp[i] == 1 ? 0 : 1;
                String t = Arrays.toString(temp);
                System.out.println(t);
                res += map.getOrDefault(t, 0L);
                System.out.println(res);
            }
            map.put(c, map.getOrDefault(c, 0L) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] list = {"abc", "abcd", "bc", "adc"};
        System.out.println(solution(list));
    }
}
