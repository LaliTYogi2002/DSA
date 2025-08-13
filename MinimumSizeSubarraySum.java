public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        int sum = 0;
        int min = n + 1;
        while (j < n) {
            sum += nums[j];

            while (sum >= target) {
                if (j - i + 1 < min) {
                    min = j - i + 1;
                }
                sum -= nums[i];
                i++;
            }

            j++;

        }

        if (min == n + 1) {
            return 0;
        } else {
            return min;
        }
    }
}
