package Stack._144_BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class BinaryTreePreorderTraversal_Recursive {
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

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        BinaryTreePreorderTraversal_Recursive btptr = new BinaryTreePreorderTraversal_Recursive();
        List<Integer> res = btptr.preorderTraversal(root);
        System.out.println(res);

    }
}
