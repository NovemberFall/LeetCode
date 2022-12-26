package BinarySearchTree._1373_MaximumSumBSTinBinaryTree;

public class maxSumBST_BruteForce {
    public int maxSumBST(TreeNode root) {
        int[] maxSum = {0};
        recursion(root, maxSum);
        return Math.max(0, maxSum[0]);
    }

    private void recursion(TreeNode root, int[] maxSum) {
        if (root == null) {
            return;
        }
        if (isBST(root)) {
            int curSum = getSum(root);
            maxSum[0] = Math.max(maxSum[0], curSum);
        }
        recursion(root.left, maxSum);
        recursion(root.right, maxSum);
    }

    private boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return isBST(root.left, minValue, root.val) &&
                isBST(root.right, root.val, maxValue);
    }

    private int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        return leftSum + rightSum + root.val;
    }
}
