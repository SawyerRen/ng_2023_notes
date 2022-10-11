package company.bloomberg.goodluck;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    static private void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int pivotIndex = partition(arr, left, right);
        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, right);
    }

    static private int partition(int[] arr, int left, int right) {
        int randomIndex = new Random().nextInt(right - left) + left;
        swap(arr, randomIndex, left);
        int pivot = arr[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && arr[j] >= pivot) j--;
            while (i < j && arr[i] <= pivot) i++;
            if (i < j) swap(arr, i, j);
        }
        swap(arr, i, left);
        return i;
    }

    static private void swap(int[] arr, int i, int j) {
        int n = arr[i];
        arr[i] = arr[j];
        arr[j] = n;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 32, 54, 12, 21};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
