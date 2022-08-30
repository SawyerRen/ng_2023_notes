package company.bloomberg.q800;

import java.util.Arrays;

public class Q881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int count = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                count++;
                left++;
                right--;
            } else {
                right--;
                count++;
            }
        }
        return count;
    }
}
