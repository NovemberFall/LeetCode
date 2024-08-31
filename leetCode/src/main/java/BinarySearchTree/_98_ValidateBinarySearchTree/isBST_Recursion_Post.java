package BinarySearchTree._98_ValidateBinarySearchTree;

class isBST_Recursion_Post {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }

        int x = root.val;

        if (left < x && x < right) {
            return isBST(root.left, left, x)
                    &&
                    isBST(root.right, x, right);
        }

        return false;
    }
}
