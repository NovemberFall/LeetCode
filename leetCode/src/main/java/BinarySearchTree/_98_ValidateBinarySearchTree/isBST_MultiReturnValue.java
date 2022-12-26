package BinarySearchTree._98_ValidateBinarySearchTree;

public class isBST_MultiReturnValue {
    static class ReturnType {
        int subtreeMax;
        int subtreeMin;
        boolean isBST;

        public ReturnType(int subtreeMax, int subtreeMin, boolean isBST) {
            this.subtreeMax = subtreeMax;
            this.subtreeMin = subtreeMin;
            this.isBST = isBST;
        }
    }

    public boolean isValidBST(TreeNode root) {
        ReturnType result = recursion(root);
        return result.isBST;
    }

    private ReturnType recursion(TreeNode root) {
        if (root == null) {
            return new ReturnType(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
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

        int curMax = Math.max(root.val, right.subtreeMax);
        int curMin = Math.max(root.val, left.subtreeMin);

        return new ReturnType(curMax, curMin, true);
    }
}
