package BinarySearchTree._98_ValidateBinarySearchTree;

/**

                        10(min=-inf, max =+inf) == root

                       /                      \

                5(min=-inf,max=10)  AND         15

              /         \                     /    \

    2(min=-inf,max=5)   X(min=5,max=10)      12     20


    why we set root, min = -inf, max = +inf ?
        because we don't know its left child and right child,
        we need to know if current level is so far so good.

    Time = O(n)    : since we need to iterate all nodes
    Space = O(height)

 */
class isBST_Recursion {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isBST(root.left, min, root.val) &&
                isBST(root.right, root.val, max);
    }


    public static void main(String[] args) {
        TreeNode root = create();
        isBST_Recursion isBSTRecursion = new isBST_Recursion();
        System.out.println(isBSTRecursion.isValidBST(root));
    }



    public static TreeNode create() {
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
}
