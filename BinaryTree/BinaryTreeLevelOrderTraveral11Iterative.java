package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraveral11Iterative {
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        return levelOrderBottomIterative(root);
    }

    public List<List<Integer>> levelOrderBottomIterative(TreeNode root){
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(root == null){
           return ans;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        // boolean lefttoright = true;
        while(!q.isEmpty()){
            int size = q.size();
            LinkedList<Integer> temp = new LinkedList<>();

            for(int i = 0 ; i<size ; i++){
                TreeNode node = q.poll();
                // if(lefttoright){
                    temp.addLast(node.val);
                // }else{
                    // temp.addFirst(node.val);
                // }

                if(node.left != null){
                    q.offer(node.left);
                }

                if(node.right != null){
                    q.offer(node.right);
                }
            }

            ans.add(0,temp);
            // lefttoright = !lefttoright;



        }

        return ans;


    }
}
