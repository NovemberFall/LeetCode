package BinarySearchTree;

class _99_RecoverBinarySearchTree {
    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRecursion(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    private void inOrderRecursion(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderRecursion(root.left);

        if (firstNode == null && prev.val > root.val) {
            firstNode = prev;
        }
        if (firstNode != null && prev.val > root.val) {
            secondNode = root;
        }
        prev = root;

        inOrderRecursion(root.right);
    }
}
