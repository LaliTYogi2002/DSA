package Binary_Search;

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {

        int s = 0;
        int e = nums.length - 1;
        int n = nums.length;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // without this 275 cases passes
            if (nums[s] == nums[mid]) {
                s++;

                continue;
            }

            // checking left array sorted
            if (nums[s] <= nums[mid]) {
                if (target >= nums[s] && target < nums[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
                // checking right array sorted
            } else {
                if (target > nums[mid] && nums[e] >= target) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }

        return false;
    }
}
