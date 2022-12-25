package BinaryTree._958_CheckCompletenessOfBinaryTree;

class CheckCompleted_Recursion {
    static class ReturnType {
        boolean isPerfect;
        boolean isCompete;
        int height;

        public ReturnType(boolean isPerfect, boolean isCompete, int height) {
            this.isPerfect = isPerfect;
            this.isCompete = isCompete;
            this.height = height;
        }
    }
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        ReturnType result = recursion(root);
        return result.isCompete;
    }

    private ReturnType recursion(TreeNode root) {
        // base case
        if (root == null) {
            return new ReturnType(true, true, 0);
        }

        // Sub problem
        ReturnType left = recursion(root.left);
        if (!left.isCompete) {
            return new ReturnType(false, false, -1);
        }
        ReturnType right = recursion(root.right);
        if (!right.isCompete) {
            return new ReturnType(false, false, -1);
        }

        // recursive rule
        boolean currentIsPerfect = left.isPerfect && right.isPerfect && left.height == right.height;

        return null;
    }
}
