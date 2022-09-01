package company.bloomberg.q1500;

import java.util.HashSet;
import java.util.Set;

public class Q1583 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] notLike = new int[n][n - 1];
        for (int i = 0; i < preferences.length; i++) {
            for (int j = 0; j < preferences[i].length; j++) {
                notLike[i][preferences[i][j]] = j;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < pairs.length; i++) {
            for (int j = i + 1; j < pairs.length; j++) {
                int one = pairs[i][0], two = pairs[i][1], three = pairs[j][0], four = pairs[j][1];
                if (notLike[one][two] > notLike[one][three] && notLike[three][four] > notLike[three][one]) {
                    set.add(one);
                    set.add(three);
                }
            }
        }
        return set.size();
    }
}
