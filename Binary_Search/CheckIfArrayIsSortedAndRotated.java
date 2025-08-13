package Binary_Search;

public class CheckIfArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        int n = nums.length;
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n])
                c++;

            // because in sorted rotated array left element can be great only 1 item 
            // if array is not sorted c will be greater than 1 and we got answer.
            if (c > 1)
                return false;
        }
        return true;
    }
}
