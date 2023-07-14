package BinaryTree;

class _543_DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int[] diameter = new int[1];
        dfs(root, diameter);
        return diameter[0];
    }

    private int dfs(TreeNode root, int[] diameter) {
        if (root == null) return 0;

        int ld = dfs(root.left, diameter);
        int rd = dfs(root.right, diameter);
        diameter[0] = Math.max(diameter[0], ld + rd);
        return Math.max(ld, rd) + 1;
    }
}
