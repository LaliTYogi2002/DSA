package Binary_Search;

public class PaintersProblemGeek {
    public int minTime(int[] nums, int k) {
        // code here
        int n = nums.length;

        int left = -1;
        int right = 0;

        for (int i = 0; i < n; i++) {
            left = Math.max(left, nums[i]);
            right += nums[i];
        }
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(nums, mid, k)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;

    }

    public boolean isPossible(int nums[], int sum, int k) {
        int cnt = 1;
        int sumArr = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sumArr + nums[i] > sum) {
                cnt++;
                sumArr = nums[i];
            } else {
                sumArr += nums[i];
            }
        }

        return cnt <= k;
    }
}
