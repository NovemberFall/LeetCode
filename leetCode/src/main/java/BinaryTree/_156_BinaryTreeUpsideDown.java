package BinaryTree;

class _156_BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }

        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.right = root;
        root.left.left = root.right;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    public TreeNode upsideDownBinaryTree_II(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.left == null) {
            return root;
        }

        TreeNode newRoot = upsideDownBinaryTree_II(root.left);
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        leftNode.right = root;
        leftNode.left = rightNode;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
