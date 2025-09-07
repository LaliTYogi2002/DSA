package BinaryTree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversalRecursive {
    public ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        solve(root, 0);

        for(int i = 0 ;i<ans.size() ;i++){
            if(i%2 != 0){
                Collections.reverse(ans.get(i));
            }
        }
        return ans;
    }

    public void solve(TreeNode root, int height){
        if(root == null){
            return;
        }


        if(height<ans.size()){
            ans.get(height).add(root.val);
        }else{
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(root.val);
            ans.add(temp);
        }

        solve(root.left , height+1);
        solve(root.right , height+1);
    }
}
