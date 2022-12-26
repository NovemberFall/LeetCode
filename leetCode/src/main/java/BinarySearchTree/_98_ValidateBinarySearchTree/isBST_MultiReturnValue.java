package BinarySearchTree._98_ValidateBinarySearchTree;

public class isBST_MultiReturnValue {
    static class ReturnType {
        long subtreeMin;
        long subtreeMax;
        boolean isBST;

        public ReturnType(long subtreeMin, long subtreeMax, boolean isBST) {
            this.subtreeMin = subtreeMin;
            this.subtreeMax = subtreeMax;
            this.isBST = isBST;
        }
    }

    public boolean isValidBST(TreeNode root) {
        ReturnType result = recursion(root);
        return result.isBST;
    }

    private ReturnType recursion(TreeNode root) {
        if (root == null) {
            return new ReturnType(Long.MAX_VALUE, Long.MIN_VALUE, true);
        }

        // leaf Node
        if (root.left == null && root.right == null) {
            return new ReturnType(root.val, root.val, true);
        }

        ReturnType left = recursion(root.left);
        ReturnType right = recursion(root.right);

        if (!left.isBST || !right.isBST) {
            return new ReturnType(-1, -1, false);
        }

        if (left.subtreeMax >= root.val || root.val >= right.subtreeMin) {
            return new ReturnType(-1, -1, false);
        }

        long curMin = Math.min(root.val, left.subtreeMin);
        long curMax = Math.max(root.val, right.subtreeMax);

        return new ReturnType(curMin, curMax, true);
    }
}
