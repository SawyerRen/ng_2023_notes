package company.bloomberg.q1500;

import java.util.HashSet;
import java.util.Set;

public class Q1583 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] prefer = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < preferences[i].length; j++) {
                prefer[i][preferences[i][j]] = j;
            }
        }
        Set<Integer> unHappySet = new HashSet<>();
        for (int i = 0; i < pairs.length; i++) {
            for (int j = i + 1; j < pairs.length; j++) {
                int one = pairs[i][0], two = pairs[i][1], three = pairs[j][0], four = pairs[j][1];
                if (prefer[one][two] > prefer[one][three] && prefer[three][four] > prefer[three][one]) {
                    unHappySet.add(one);
                    unHappySet.add(three);
                }
                if (prefer[one][two] > prefer[one][four] && prefer[four][three] > prefer[four][one]) {
                    unHappySet.add(one);
                    unHappySet.add(four);
                }
                if (prefer[two][one] > prefer[two][three] && prefer[three][four] > prefer[three][two]) {
                    unHappySet.add(two);
                    unHappySet.add(three);
                }
                if (prefer[two][one] > prefer[two][four] && prefer[four][three] > prefer[four][two]) {
                    unHappySet.add(two);
                    unHappySet.add(four);
                }
            }
        }
        return unHappySet.size();
    }
}
