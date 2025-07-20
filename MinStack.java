import java.util.Stack;

public class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minSt.isEmpty()){
            minSt.push(val);
        }else{
            if(minSt.peek()>val){
                minSt.push(val);
            }
        }

        return;
    }
    
    public void pop() {
        if(st.peek() == minSt.peek()){
            st.pop();
            minSt.pop();
            return;
        }

        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
    }
}
