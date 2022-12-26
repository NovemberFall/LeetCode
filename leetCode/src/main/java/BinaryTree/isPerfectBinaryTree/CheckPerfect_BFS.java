package BinaryTree.isPerfectBinaryTree;

import BinaryTree.isPerfectBinaryTree.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;

class CheckPerfect_BFS {
    public boolean isPerfectBinaryTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        int previousLeveSize = 0;

        while (!queue.isEmpty()) {
            int numberOfNodeInCurrentLevel = queue.size();
            if (level > 0 && numberOfNodeInCurrentLevel != 2 * previousLeveSize) {
                return false;
            }
            for (int i = 0; i < numberOfNodeInCurrentLevel; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            previousLeveSize = numberOfNodeInCurrentLevel;
        }
        return true;
    }
}
