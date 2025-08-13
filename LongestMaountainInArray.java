public class LongestMaountainInArray {
    public int longestMountain(int[] arr) {
        if (arr.length < 3) {
            return 0;
        }
        int n = arr.length;

        int i = 1;
        int ans = 0;
        while (i < n - 1) {
            boolean isPeak = arr[i] > arr[i - 1] && arr[i] > arr[i + 1];
            if (isPeak) {
                int left = i;
                int right = i;

                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }

                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                int min = right - left + 1;
                ans = Math.max(min, ans);

                i = right;
                ;
            } else {
                i++;
            }
        }

        return ans;
    }
}
