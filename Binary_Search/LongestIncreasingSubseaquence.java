package Binary_Search;
import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubseaquence{
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ;i<n ;i++){
            if(res.size() ==0 || res.get(res.size()-1) < nums[i]){
                res.add(nums[i]);
            }else{
                int idx = binarySearch(res, nums[i]);
                res.set(idx, nums[i]);
            }
        }


        return res.size();
    }

    public int binarySearch(List<Integer> arr, int target){


        int left = 0 ;
        int right = arr.size()-1;

        while(left <= right){
            int mid = left + (right-left) /2 ;

            if(arr.get(mid) == target){
                return mid;
            }else if(arr.get(mid) > target){
                right = mid -1;
            }else{
                left = mid+1;
            }
        }


        return left ;
    }
}