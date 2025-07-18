import java.util.Stack;

class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        
        int nrs[] = nearestRightSmallerInderArray(heights);
        int nls[] = nearestLeftSmallerInderArray(heights);

        // for(int i = 0 ;i<heights.length ;i++){
        //     System.out.println(nrs[i]);
        //     System.out.println(nls[i]);
        // }
    int ans = -1 ; 
        for(int i = 0 ;i<heights.length ; i++){
            // here is the use of nearest right and left small for calculate the width
            // logic is that till which index we can height[i] right and left. 
            int widht = nrs[i] - nls[i] - 1;
            ans = Math.max(widht*heights[i], ans); 
        }

        return ans ;

    }

    public int[] nearestRightSmallerInderArray(int height[]){
        Stack<Integer> st = new Stack<>();
        int res[] = new int[height.length];

        for(int i = height.length-1 ; i>=0 ;i--){
            while(!st.isEmpty()){
                if(height[st.peek()]<height[i]){
                    res[i] =  st.peek();
                    st.push(i);
                    break;
                }else{
                    st.pop();
                }
            }

            if(st.isEmpty()){
                st.push(i);
                res[i] = height.length;
            }
        }
    
        return res;
    }

     public int[] nearestLeftSmallerInderArray(int height[]){
        Stack<Integer> st = new Stack<>();
        int res[] = new int[height.length];
        for(int i = 0 ; i<height.length ;i++){
            while(!st.isEmpty()){
                if(height[st.peek()]<height[i]){
                    res[i] =  st.peek();
                    st.push(i);
                    break;
                }else{
                    st.pop();
                }
            }

            if(st.isEmpty()){
                st.push(i);
                res[i] =-1;
            }
        }

        return res;
    }
}