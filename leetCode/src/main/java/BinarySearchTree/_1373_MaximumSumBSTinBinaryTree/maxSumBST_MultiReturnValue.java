package BinarySearchTree._1373_MaximumSumBSTinBinaryTree;

class maxSumBST_MultiReturnValue {
    static class ReturnType {
        int sum;
        int min;
        int max;

        public ReturnType(int sum, int min, int max) {
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }

    public int maxSumBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] maxSum = {0};
        findMaxSum(root, maxSum);
        return maxSum[0];
    }

    private ReturnType findMaxSum(TreeNode root, int[] maxSum) {
        if (root == null) {
            return new ReturnType(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        ReturnType left = findMaxSum(root.left, maxSum);
        ReturnType right = findMaxSum(root.right, maxSum);

        if (left != null && right != null) {
            if (root.val > left.max && root.val < right.min) {
                int curSum = root.val + left.sum + right.sum;
                maxSum[0] = Math.max(maxSum[0], curSum);
                int curMin = Math.min(root.val, left.min);
                int curMax = Math.max(root.val, right.max);
                return new ReturnType(curSum, curMin, curMax);
            }
        }
        return null;
    }
}
