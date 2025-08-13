package Binary_Search;

public class FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {

        int maxPoint = findMaximum(mountainArr);

        int ascMin = solveIncreasingSide(mountainArr, maxPoint, target);
        int descMin = solveDecreasingSide(mountainArr, maxPoint, target);

        int min = Math.min(ascMin, descMin);
        if (min == Integer.MAX_VALUE) {
            return -1;
        }

        return min;
    }

    public int solveIncreasingSide(MountainArray arr, int maxPoint, int target) {
        int left = 0;
        int right = maxPoint;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int midVal = arr.get(mid);
            if (midVal == target) {
                return mid;
            }

            if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Integer.MAX_VALUE;
    }

    public int solveDecreasingSide(MountainArray arr, int maxPoint, int target) {
        int left = maxPoint + 1;
        int right = arr.length() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int midVal = arr.get(mid);
            if (midVal == target) {
                return mid;
            }

            if (midVal > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Integer.MAX_VALUE;
    }

    public int findMaximum(MountainArray arr) {
        // code here
        int left = 0;
        int right = arr.length() - 1;

        int n = arr.length();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = arr.get(mid);
            int next = arr.get((mid + 1) % n);
            int prev = arr.get((n + mid - 1) % n);
            if (midVal > next && midVal > prev) {
                return mid;
            }

            // standing on increasing side
            if (midVal < next && midVal > prev) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return 0;
    }
}
