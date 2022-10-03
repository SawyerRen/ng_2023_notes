package company.uber.lastround;

public class Q414 {
    public int thirdMax(int[] nums) {
        Integer max1 = null, max2 = null, max3 = null;
        for (Integer num : nums) {
            if (num.equals(max1) || num.equals(max2) || num.equals(max3)) continue;
            if (max1 == null || max1 < num) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (max2 == null || max2 < num) {
                max3 = max2;
                max2 = num;
            } else if (max3 == null || max3 < num) {
                max3 = num;
            }
        }
        return max3 == null ? max1 : max3;
    }
}
