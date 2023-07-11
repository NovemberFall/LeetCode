package BinaryTree;

public class _226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        // swap the children
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
