package BinarySearchTree;

class _235_LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (root == p || root == q) return root;

        int val = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if (val > pVal && val > qVal) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (val < pVal && val < qVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
