package Binary_Search;

public class BitonicPoint {
    public int findMaximum(int[] arr) {
        // code here
        int left = 0;
        int right = arr.length - 1;

        int n = arr.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[(mid + 1) % n] && arr[mid] > arr[(n + mid - 1) % n]) {
                return arr[mid];
            }

            // standing on increasing side
            if (arr[mid] < arr[(mid + 1) % n] && arr[mid] > arr[(n + mid - 1) % n]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return 0;
    }
}
