import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque();
        int n = nums.length ;

        int res[] = new int[n-k+1];
        // monotonic deque
        for(int i = 0;i< n ;i++){

            // remove previous all small elements because no need of them.
            while(!dq.isEmpty() && nums[dq.getFirst()]<nums[i]){
                dq.removeFirst();
            }


            // remove index which not valid for window.
            if(!dq.isEmpty() && dq.getLast() < i-k+1){
                dq.removeLast();
            }


            dq.addFirst(i);

            // check for window is valid or not till now
            if(i-k+1 <0){
                continue;
            }


            res[i-k+1] = nums[dq.getLast()];

        }

        return res ;
    }   
}
