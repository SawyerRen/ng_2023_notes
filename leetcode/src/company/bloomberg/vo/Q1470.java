package company.bloomberg.vo;

public class Q1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int i1 = 0, i2 = nums.length / 2;
        for (int i = 0; i < nums.length; i += 2) {
            res[i] = nums[i1++];
            res[i + 1] = nums[i2++];
        }
        return res;
    }
}
