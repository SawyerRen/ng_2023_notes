package company.amazon.other;

/**
 * Example
 * Input:
 * [1, 1, 1, 0, 0, 1]
 * Output: 2
 * First Swap:
 * [1, 1, 1, 0,‍‍‍‍‌‍‌‌‍‌‍‌‌‍‍‌‌‍‍ 1, 0]
 * Second Swap:
 * [1, 1, 1, 1, 0, 0]
 */
public class MinSwapsToMove1And0ToBothSides {
    static public int solution(int[] arr) {
        int count = 0;
        int zeroCount = 0;
        for (int i : arr) {
            if (i == 0) zeroCount++;
            else count += zeroCount;
        }
        zeroCount = 0;
        int count2 = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0) zeroCount++;
            else count2 += zeroCount;
        }
        return Math.min(count, count2);
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 1};
        System.out.println(solution(arr));
    }
}
