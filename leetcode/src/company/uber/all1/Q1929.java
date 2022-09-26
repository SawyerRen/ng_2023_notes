package company.uber.all1;

public class Q1929 {
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            res[i] = res[i + nums.length] = nums[i];
        }
        return res;
    }
}
