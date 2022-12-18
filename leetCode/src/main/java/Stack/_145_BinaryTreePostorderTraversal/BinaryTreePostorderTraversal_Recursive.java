package Stack._145_BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;

class BinaryTreePostorderTraversal_Recursive {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    private void postOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
        System.out.println(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        BinaryTreePostorderTraversal_Recursive btptr = new BinaryTreePostorderTraversal_Recursive();
        List<Integer> res = btptr.postorderTraversal(root);
        System.out.println(res);
    }
}
