import java.util.Stack;

class RainWaterTrapping{
     public int trap(int[] height) {
        int nrm[] = nearestRightMax(height);
        int nlm[] = nearestLeftMax(height);
        int ans = 0 ;
        for(int i = 0;i<height.length ; i++){
            int min = Math.min(nrm[i],nlm[i]);
            if(min!=-1){
                ans += min - height[i];
            }
        }

        return ans;
    }

    public int[] nearestRightMax(int arr[]){
        Stack<Integer> st = new Stack<Integer>();
        int res[] = new int[arr.length];
        for(int i=arr.length-1; i>=0 ;i--){
            while(!st.isEmpty()){
                if(st.peek()>arr[i]){
                    res[i] = st.peek();
                    break;
                }else{
                    st.pop();
                }
            }

            if(st.isEmpty()){
                res[i] = -1;
                st.push(arr[i]);
            }
        }

        return res;
    }

    public int[] nearestLeftMax(int arr[]){
        Stack<Integer> st = new Stack<Integer>();
        int res[] = new int[arr.length];
        for(int i=0; i<arr.length ;i++){
            while(!st.isEmpty()){
                if(st.peek()>arr[i]){
                    res[i] = st.peek();
                    break;
                }else{
                    st.pop();
                }
            }

            if(st.isEmpty()){
                res[i] = -1;
                st.push(arr[i]);
            }
        }

        return res;
    }
}