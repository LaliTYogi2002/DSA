package BinaryTree;

public class HouseRobIII {
    public class Pair {
        int left;
        int right;

        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

    }

    public int rob(TreeNode root) {

        Pair ans = solve(root);

        return Math.max(ans.left, ans.right);
    }

    public Pair solve(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair left = solve(root.left);
        Pair right = solve(root.right);

        int withRoot = left.right + right.right + root.val;
        int withOutRoot = Math.max(left.left, left.right) + Math.max(right.left, right.right);

        return new Pair(withRoot, withOutRoot);
    }

}
