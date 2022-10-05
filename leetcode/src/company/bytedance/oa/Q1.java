package company.bytedance.oa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 一个数组a，可以给其中任意个数加上1然后对a重排列，问能否等于另一个数组b
 */
public class Q1 {
    static boolean solution(String a, String b) {
        if (a.length() != b.length()) return false;
        String[] arr1 = a.split(" ");
        String[] arr2 = b.split(" ");
        if (arr1.length != arr2.length) return false;
        int[] nums1 = new int[arr1.length];
        int[] nums2 = new int[arr2.length];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = Integer.parseInt(arr1[i]);
            nums2[i] = Integer.parseInt(arr2[i]);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != nums2[i] && nums1[i] + 1 != nums2[i]) {
                System.out.println(nums1[i]);
                System.out.println(nums2[i]);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "0 0 0 10 10";
        String b = "0 1 0 10 11";
        System.out.println(solution(a, b));
    }
}
