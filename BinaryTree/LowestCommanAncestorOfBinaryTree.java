package BinaryTree;

public class LowestCommanAncestorOfBinaryTree {

    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        solve(root, p, q);
        return ans;

    }

    public boolean solve(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        boolean left = solve(root.left, p, q);
        boolean right = solve(root.right, p, q);

        boolean curr = (p.val == root.val || q.val == root.val);
        if ((left && right) || (curr && left) || (curr && right)) {
            ans = root;
            return true;
        }

        return curr || left || right;

    }

}