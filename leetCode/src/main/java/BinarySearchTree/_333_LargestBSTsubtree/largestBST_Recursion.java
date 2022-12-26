package BinarySearchTree._333_LargestBSTsubtree;

public class largestBST_Recursion {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isBST(root)) {
            return getSize(root);
        }
        int leftBSTSubtree = largestBSTSubtree(root.left);
        int rightBSTSubtree = largestBSTSubtree(root.right);
        return Math.max(leftBSTSubtree, rightBSTSubtree);
    }

    private boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isBST(root.left, min, root.val) &&
                isBST(root.right, root.val, max);
    }

    private int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getSize(root.left);
        int right = getSize(root.right);
        return left + right + 1;
    }
}
