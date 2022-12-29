package BinaryTree._199_BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

class BinaryTreeRightSideView_recursion {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        recursion(root, res, 0);
        return res;
    }

    private void recursion(TreeNode root, List<Integer> res, int curLevel) {
        if (root == null) {
            return;
        }
        if (res.size() == curLevel) {
            res.add(root.val);
        }
        recursion(root.right, res, curLevel + 1);
        recursion(root.left, res, curLevel + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(4);
        BinaryTreeRightSideView_recursion btrsvr = new BinaryTreeRightSideView_recursion();
        List<Integer> res = btrsvr.rightSideView(root);
        System.out.println(res); // [1, 2, 3, 4]
    }
}
