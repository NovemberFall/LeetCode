package BinaryTree;

class _114_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        TreeNode[] prev = new TreeNode[1];
        postOrder_FromRightToLeft(root, prev);
    }

    private void postOrder_FromRightToLeft(TreeNode root, TreeNode[] prev) {
        if (root == null) {
            return;
        }
        postOrder_FromRightToLeft(root.right, prev);
        postOrder_FromRightToLeft(root.left, prev);
        root.right = prev[0];
        root.left = null;
        prev[0] = root;
    }
}
