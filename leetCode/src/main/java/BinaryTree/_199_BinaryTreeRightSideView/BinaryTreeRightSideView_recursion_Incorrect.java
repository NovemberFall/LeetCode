package BinaryTree._199_BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

class BinaryTreeRightSideView_recursion_Incorrect {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        recursion(root, res);
        return res;
    }

    private void recursion(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        recursion(root.right, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
        BinaryTreeRightSideView_recursion_Incorrect btrsri = new BinaryTreeRightSideView_recursion_Incorrect();
        List<Integer> res = btrsri.rightSideView(root);
        System.out.println(res);
    }
}
