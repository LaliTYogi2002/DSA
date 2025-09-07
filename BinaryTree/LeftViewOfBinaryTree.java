package BinaryTree;

import java.util.ArrayList;

public class LeftViewOfBinaryTree {
    public ArrayList<Integer> ans = new ArrayList<Integer>();
    public ArrayList<Integer> leftView(TreeNode root) {
        // code here
        
       solve(root,0);
       return ans;
    }
    


    public void solve(TreeNode root, int height){
        if(root ==null){
            return ;
        }
        
        if(ans.size() == height){
            ans.add(root.val);
        }

        // ans.set(height, root.val);
        solve(root.left, height+1);
        solve(root.right, height+1);
    }

}
