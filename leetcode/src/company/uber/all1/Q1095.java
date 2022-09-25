package company.uber.all1;

public class Q1095 {
    interface MountainArray {
        public int get(int index);

        public int length();
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = getPeak(mountainArr);
        int left = 0, right = peakIndex;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) return mid;
            if (mountainArr.get(mid) < target) left = mid + 1;
            else right = mid - 1;
        }
        left = peakIndex;
        right = mountainArr.length() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) return mid;
            if (mountainArr.get(mid) > target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    private int getPeak(MountainArray mountainArr) {
        int left = 0, right = mountainArr.length() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
