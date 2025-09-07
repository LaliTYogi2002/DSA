package BinaryTree;

public class DiameterofBinaryTree {
    public class Pair {

        int sum;
        int max;

        Pair(int sum, int max) {
            this.sum = sum;
            this.max = max;
        }
    }

    public int max;

    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return max;
        // return solve(root.left) + solve(root.right);

    }

    public int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = solve(root.left);
        int right = solve(root.right);

        int tempMax = left + right;
        if (tempMax > max) {
            max = tempMax;
        }

        return Math.max(right, left) + 1;
    }
}
