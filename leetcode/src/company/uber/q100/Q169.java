package company.uber.q100;

public class Q169 {
    public int majorityElement(int[] nums) {
        int candidate = nums[0], count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
