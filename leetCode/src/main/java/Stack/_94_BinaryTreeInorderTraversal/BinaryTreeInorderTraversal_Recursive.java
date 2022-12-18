package Stack._94_BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;

class BinaryTreeInorderTraversal_Recursive {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        inOrder(root.left, res);
        System.out.println(root.val);
        res.add(root.val);
        inOrder(root.right, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        BinaryTreeInorderTraversal_Recursive btitr = new BinaryTreeInorderTraversal_Recursive();
        List<Integer> res = btitr.inorderTraversal(root);
        System.out.println(res);
        // [1   2   3   5   8]
    }
}
