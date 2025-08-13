public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        // think it as a cyclic linked list element point to index
        // find first intersection
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }

        int slow2 = 0;
        // find second intersection which is the starting of cycle and ans too.
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];

            if (slow == slow2) {
                return slow;
            }
        }

    }
}
