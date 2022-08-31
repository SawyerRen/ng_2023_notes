package company.bloomberg.q300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                while (i + 1 < nums1.length && nums1[i + 1] == nums1[i]) i++;
                while (j + 1 < nums2.length && nums2[j + 1] == nums2[j]) j++;
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[list.size()];
        for (int k = 0; k < res.length; k++) {
            res[k] = list.get(k);
        }
        return res;
    }
}
