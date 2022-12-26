package BinarySearchTree._333_LargestBSTsubtree;

public class largestBST_MultiReturnValue {
    private static final int INVALID = -1;

    static class ReturnType {
        int size;
        int min;
        int max;
//        boolean isBST; // isBST, 不需要因为可以通过 size = -1, 来代表不valid

        public ReturnType(int size, int min, int max) {
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] largestBSTSubtreeSize = new int[]{0};
        recursion(root, largestBSTSubtreeSize);
        return largestBSTSubtreeSize[0];
    }

    private ReturnType recursion(TreeNode root, int[] largestBSTSubtreeSize) {
        if (root == null) {
            return new ReturnType(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        ReturnType left = recursion(root.left, largestBSTSubtreeSize);
        ReturnType right = recursion(root.right, largestBSTSubtreeSize);

        if (left.size == INVALID || right.size == INVALID ||
                root.val <= left.max || root.val >= right.min) {
            return new ReturnType(INVALID, INVALID, INVALID);
        }
        int curSize = left.size + right.size + 1;
        largestBSTSubtreeSize[0] = Math.max(largestBSTSubtreeSize[0], curSize);
        int curMin = Math.min(root.val, left.min);
        int curMax = Math.max(root.val, right.max);
        return new ReturnType(curSize, curMin, curMax);
    }
}
