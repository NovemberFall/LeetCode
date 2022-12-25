package BinaryTree._958_CheckCompletenessOfBinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

class CheckCompleted {
    // This method will check if there is a child node which is null, optimal space
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        // If the flag is set true, there should not be any child nodes afterwards.
        boolean flag = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            // if any of the child is not present, set the flag to true.
            if (cur.left == null) {
                flag = true;
            } else if (flag) {
                // if flag is set, but we still see cur has a left child,
                // the binary tree is not a completed one.
                return false;
            } else {
                // if flag is not set and let child is present.
                queue.offer(cur.left);
            }

            // same logic applied to right child.
            if (cur.right == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(cur.right);
            }
        }
        return true;
    }
}
