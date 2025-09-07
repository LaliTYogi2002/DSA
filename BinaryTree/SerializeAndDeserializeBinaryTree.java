package BinaryTree;

public class SerializeAndDeserializeBinaryTree {
    
    public StringBuffer str = new StringBuffer();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            str.append("N,");
            return str.toString();
        }
        str.append(Integer.toString(root.val)).append(',');
        serialize(root.left);
        serialize(root.right);

        return str.toString();

    }

    // Decodes your encoded data to tree.

    public int index = 0;

    public TreeNode deserialize(String data) {
        if (data == "N") {
            return null;
        }
        String[] arr = data.split(",");

        // TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        return solve(arr);
        // return root;
    }

    public TreeNode solve(String[] arr) {
        if (arr[index].equals("N")) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[index]));
        index++;
        node.left = solve(arr);
        node.right = solve(arr);

        return node;
    }
}
