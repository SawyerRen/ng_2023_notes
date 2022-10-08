package company.bloomberg.vo;

import java.util.Random;

public class Q215 {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        k = nums.length - k;
        while (left < right) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex >= k) right = pivotIndex;
            else left = pivotIndex + 1;
        }
        return nums[k];
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = new Random().nextInt(right - left) + left;
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= pivot) j--;
            while (i < j && nums[i] <= pivot) i++;
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, left, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int n = nums[i];
        nums[i] = nums[j];
        nums[j] = n;
    }
}
