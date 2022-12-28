package BinaryTree;

class _111_MinimumDepth_of_BinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMinNums = minDepth(root.left);
        int rightMinNums = minDepth(root.right);

        if (root.left == null || root.right == null) {
            return Math.max(leftMinNums, rightMinNums) + 1;
        }

        return Math.min(leftMinNums, rightMinNums) + 1;
    }
}
