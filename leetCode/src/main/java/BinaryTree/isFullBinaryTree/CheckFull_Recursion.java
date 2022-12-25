package BinaryTree.isFullBinaryTree;

public class CheckFull_Recursion {
    public boolean isFullBinaryTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        // check if left subtree and right subtree
        boolean leftIsFull = isFullBinaryTree(root.left);
        boolean rightIsFull = isFullBinaryTree(root.right);
        if (!leftIsFull || !rightIsFull) {
            return false;
        }

        // 当前层 check self node
        if (root.left != null || root.right != null) {
            return false;
        }
        return true;
    }
}
