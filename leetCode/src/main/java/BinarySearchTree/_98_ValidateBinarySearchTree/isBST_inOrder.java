package BinarySearchTree._98_ValidateBinarySearchTree;

class isBST_inOrder {
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // visit the left subtree
        boolean left = isValidBST(root.left);
        // 访问当前节点：如果当前节节点点小于等于中序遍历的前一个，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        boolean right = isValidBST(root.right);

        return left && right;
    }

    private TreeNode create() {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(20);
        root.left.left = new TreeNode(10);
        root.left.left.left = new TreeNode(5);
        root.left.right = new TreeNode(30);
        root.right = new TreeNode(50);
        root.right.right = new TreeNode(60);
        root.right.left = new TreeNode(47);
        root.left.right.right = new TreeNode(36);
        return root;
    }

    public static void main(String[] args) {
        isBST_inOrder isBSTInOrder = new isBST_inOrder();
        TreeNode root = isBSTInOrder.create();
        System.out.println(isBSTInOrder.isValidBST(root));
    }
}
