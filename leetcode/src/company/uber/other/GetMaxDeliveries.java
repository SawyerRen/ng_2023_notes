package company.uber.other;

import java.util.HashMap;
import java.util.Map;

public class GetMaxDeliveries {
    static int getMaxDeliveries(int[][] triplets) {
        Map<String, Integer> memo = new HashMap<>();
        return helper(memo, triplets, 0, 0);
    }

    private static int helper(Map<String, Integer> memo, int[][] triplets, int i, int cur) {
        if (i >= triplets.length) return 0;
        String state = i + "," + cur;
        if (memo.containsKey(state)) return memo.get(state);
        int pick = triplets[i][0], receive = triplets[i][1], skip = triplets[i][2];
        int res = 0;
        res = Math.max(res, helper(memo, triplets, i + 1, cur));
        res = Math.max(res, helper(memo, triplets, i + 1 + skip, Math.max(0, cur - receive) + pick) + Math.min(cur, receive));
        memo.put(state, res);
        return res;
    }

    public static void main(String[] args) {
        int[][] triplets = {{4, 0, 2}, {6, 2, 0}, {1, 1, 0}, {4, 4, 1}, {5, 4, 0}, {4, 10, 0}};
        System.out.println(getMaxDeliveries(triplets));
    }
}
