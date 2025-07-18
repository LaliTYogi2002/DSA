import java.util.Stack;

class NextGreaterElement3{
    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> st = new Stack<Integer>();
        int res[] = new int[nums.length];
        int n = nums.length;
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty()) {
                if (st.peek() > nums[i % n]) {
                    res[i % n] = st.peek();
                    st.push(nums[i % n]);
                    break;
                } else {
                    st.pop();
                }
            }

            if (st.isEmpty()) {
                st.push(nums[i % n]);
                res[i % n] = -1;
            }
        }

        return res;
    }
}