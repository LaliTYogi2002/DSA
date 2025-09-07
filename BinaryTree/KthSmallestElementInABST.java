package BinaryTree;

import java.util.ArrayList;

public class KthSmallestElementInABST {
    public ArrayList<Integer> inorder = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        fetchInorder(root);

        return inorder.get(k-1);
    }


    public void fetchInorder(TreeNode root){
        if(root==null){
            return;
        }

        fetchInorder(root.left);
        inorder.add(root.val);
        fetchInorder(root.right);
    }
}
