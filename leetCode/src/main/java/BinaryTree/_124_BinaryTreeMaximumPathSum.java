package BinaryTree;

class _124_BinaryTreeMaximumPathSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        recursion(root, max);
        return max[0];
    }

    private int recursion(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int leftSubtree = recursion(root.left, max);
        int rightSubtree = recursion(root.right, max);
        if (leftSubtree < 0) {
            leftSubtree = 0;
        }
        if (rightSubtree < 0) {
            rightSubtree = 0;
        }
        int curSum = leftSubtree + rightSubtree + root.val;
        max[0] = Math.max(max[0], curSum);
        return Math.max(leftSubtree, rightSubtree) + root.val;
    }
}
