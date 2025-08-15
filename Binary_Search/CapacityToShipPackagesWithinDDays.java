package Binary_Search;

public class CapacityToShipPackagesWithinDDays{
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canShipAll(weights, mid, days)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return left;
    }

    public boolean canShipAll(int weights[], int capacity, int days) {
        int dayCount = 1;
        int currLoad = 0;

        for (int w : weights) {
            if (currLoad + w > capacity) {
                dayCount++;
                currLoad = 0;
            }

            currLoad += w;
            if (dayCount > days) {
                return false;
            }
        }

        return true;
    }
}