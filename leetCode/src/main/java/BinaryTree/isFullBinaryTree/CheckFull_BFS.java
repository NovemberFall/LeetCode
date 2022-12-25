package BinaryTree.isFullBinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class CheckFull_BFS {
    public boolean isFullBinaryTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left == null && cur.right == null) {
                continue;
            } else if (cur.left == null || cur.right == null) {
                return false;
            } else {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return true;
    }
}
