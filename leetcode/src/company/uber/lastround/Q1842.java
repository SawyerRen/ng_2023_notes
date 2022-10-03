package company.uber.lastround;

public class Q1842 {
    public String nextPalindrome(String num) {
        int len = num.length();
        int[] arr = new int[len / 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = num.charAt(i) - '0';
        }
        if (!helper(arr)) return "";
        StringBuilder builder = new StringBuilder();
        for (int i : arr) {
            builder.append(i);
        }
        if (len % 2 == 0) {
            return builder.toString() + builder.reverse().toString();
        } else {
            return builder.toString() + num.charAt(len / 2) + builder.reverse().toString();
        }
    }

    private boolean helper(int[] arr) {
        int l = arr.length - 2;
        while (l >= 0 && arr[l] >= arr[l + 1]) l--;
        if (l < 0) return false;
        int r = arr.length - 1;
        while (arr[l] >= arr[r]) r--;
        swap(arr, l, r);
        int i = l + 1, j = arr.length - 1;
        while (i < j) {
            swap(arr, i++, j--);
        }
        return true;
    }

    private void swap(int[] arr, int l, int r) {
        int n = arr[l];
        arr[l] = arr[r];
        arr[r] = n;
    }
}
