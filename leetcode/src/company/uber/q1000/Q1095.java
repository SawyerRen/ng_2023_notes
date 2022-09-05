package company.uber.q1000;

public class Q1095 {
    interface MountainArray {
        public int get(int index);

        public int length();
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0, right = mountainArr.length() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) right = mid;
            else left = mid + 1;
        }
        int peakIndex = left;
        left = 0;
        right = peakIndex;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) return mid;
            if (mountainArr.get(mid) > target) right = mid - 1;
            else left = mid + 1;
        }
        left = peakIndex;
        right = mountainArr.length() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) return mid;
            if (mountainArr.get(mid) < target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}
