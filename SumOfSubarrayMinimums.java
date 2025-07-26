import java.util.Stack;

public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length ;
        int pse[] = previousSmallElement(arr, n);
        int nse[] = nextSmallElement(arr, n);

        for(int i =0 ;i<n ;i++){
            System.out.println(pse[i]);
            System.out.println(nse[i]);
        }
        long ans = 0 ;
            int mod = 1_000_000_007;
        for(int i = 0 ;i < n ; i++){
            int lengthOfRightSubarray = nse[i]-i ; 
            int lengthOfLeftSubarray = i-pse[i] ;

            ans = (ans + (long) arr[i] * lengthOfLeftSubarray * lengthOfRightSubarray) % mod;

        }

        return (int) ans;
    }

    public int[] previousSmallElement(int arr[], int n){
        Stack<Integer> st = new Stack<>();

        int res[] = new int[n];
        for(int i=0 ;i<n;i++){
            while(!st.isEmpty()){
                if(arr[st.peek()]<arr[i]){
                    res[i] = st.peek();
                    st.push(i);
                    break;
                }else{
                    st.pop();
                }
            }

            if(st.isEmpty()){
                res[i] = -1;
                st.push(i);
            }
        }

        return res;
    }
    

    public int[] nextSmallElement(int arr[], int n){
        Stack<Integer> st = new Stack<>();

        int res[] = new int[n];
        for(int i=n-1 ;i>=0;i--){
            while(!st.isEmpty()){
                if(arr[st.peek()]<=arr[i]){
                    res[i] = st.peek();
                    st.push(i);
                    break;
                }else{
                    st.pop();
                }
            }

            if(st.isEmpty()){
                res[i] = n;
                st.push(i);
            }
        }

        return res;
    }
}
