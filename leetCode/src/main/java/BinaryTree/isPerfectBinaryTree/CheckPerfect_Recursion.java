package BinaryTree.isPerfectBinaryTree;

class CheckPerfect_Recursion {
    static class ReturnType {
        boolean isPerfect;
        int height;

        public ReturnType(boolean isPerfect, int height) {
            this.isPerfect = isPerfect;
            this.height = height;
        }
    }
    public boolean isPerfectBinaryTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        ReturnType result = recursion(root);
        return result.isPerfect;
    }

    private ReturnType recursion(TreeNode root) {
        if (root == null) {
            return new ReturnType(true, 0);
        }
        if (root.left == null && root.right == null) {
            return new ReturnType(true, 1);
        }
        ReturnType left = recursion(root.left);
        ReturnType right = recursion(root.right);

        if (left.isPerfect && right.isPerfect && left.height == right.height) {
            return new ReturnType(true, left.height + 1);
        } else {
            return new ReturnType(false, -1);
        }
    }
}
