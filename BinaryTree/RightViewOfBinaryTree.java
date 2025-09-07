package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class RightViewOfBinaryTree {
    public ArrayList<Integer> ans  = new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {

        solve(root,0);
        return ans;
    }

    public void solve(TreeNode root, int level){
        if(root == null){
            return ;
        }

        if(level < ans.size()){
            ans.set(level,root.val);
        }else{
            ans.add(root.val);
        }

        solve(root.left,level+1);
        solve(root.right,level+1);
    }
}
