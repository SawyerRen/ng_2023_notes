package company.expedia.oa;

public class EvenTag {
    static int solution(int[] arr) {
        int res = 0;
        int temp = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > 0) res += i;
            else if (i < 0 && i % 2 != 0) {
                temp = Math.max(temp, i);
            }
        }
        if (res % 2 == 0) return res;
        return res + temp;
    }
}
