package BinaryTree._110_BalancedBinaryTree;

class BalancedBinaryTree_Multi_ReturnValue {
    static class ReturnValue {
        int height;
        boolean isBalance;

        ReturnValue(int h, boolean isBalance) {
            this.height = h;
            this.isBalance = isBalance;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        ReturnValue result = recursion(root);
        return result.isBalance;
    }

    private ReturnValue recursion(TreeNode root) {
        if (root == null) {
            return new ReturnValue(0, true);
        }
        ReturnValue left = recursion(root.left);
        ReturnValue right = recursion(root.right);

        int curHeight = Math.max(left.height, right.height) + 1;
        boolean curIsBalance = false;

        if (left.isBalance && right.isBalance &&
                Math.abs(left.height - right.height) <= 1) {
            curIsBalance = true;
        }
        return new ReturnValue(curHeight, curIsBalance);
    }
}
