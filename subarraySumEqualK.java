import java.util.HashMap;

public class subarraySumEqualK {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length,count=0;
        int[] ps=new int[n];
        ps[0]=nums[0];
        for(int i=1;i<n;i++){
            ps[i]=ps[i-1]+nums[i];
        }
        HashMap<Integer,Integer> m =new HashMap<>();
        for(int j=0;j<n;j++){
            if(ps[j]==k){
                count++;
            }
            int val=ps[j]-k;
            if(m.containsKey(val)){
                count+=m.get(val);
            }
            if(m.containsKey(ps[j])){
                m.put(ps[j],m.get(ps[j])+1);
            }
            else{
                m.put(ps[j],1);
            }
        
        }
        return count;
    }
}