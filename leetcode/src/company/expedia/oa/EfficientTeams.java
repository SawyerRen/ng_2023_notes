package company.expedia.oa;

import java.util.HashMap;
import java.util.Map;

public class EfficientTeams {
    static int solution(int[] skills) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int skill : skills) {
            sum += skill;
            map.put(skill, map.getOrDefault(skill, 0) + 1);
        }
        int n = skills.length;
        if (sum % (n / 2) != 0) return -1;
        int target = sum / (n / 2);
        int res = 0;
        for (Integer s1 : map.keySet()) {
            int s2 = target - s1;
            if (!map.containsKey(s2) || !map.get(s1).equals(map.get(s2))) return -1;
            if (s1 == s2) {
                res += s1 * s2 * map.get(s1) / 2;
            } else {
                res += s1 * s2 * map.get(s1);
            }
            map.put(s1, 0);
            map.put(s2, 0);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] s = {1, 2, 3, 2};
        System.out.println(solution(s));
    }
}
