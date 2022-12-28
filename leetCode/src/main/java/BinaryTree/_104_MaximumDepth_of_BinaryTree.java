package BinaryTree;

class _104_MaximumDepth_of_BinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftNums = maxDepth(root.left);
        int rightNums = maxDepth(root.right);
        return Math.max(leftNums, rightNums) + 1;
    }
}
