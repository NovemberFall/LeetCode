package BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class _103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int level = 1;
        while (!deque.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                if (level % 2 == 0) {
                    TreeNode cur = deque.pollFirst();
                    temp.add(cur.val);
                    if (cur.right != null) {
                        deque.offerLast(cur.right);
                    }
                    if (cur.left != null) {
                        deque.offerLast(cur.left);
                    }
                } else {
                    TreeNode cur = deque.pollLast();
                    temp.add(cur.val);
                    if (cur.left != null) {
                        deque.offerFirst(cur.left);
                    }
                    if (cur.right != null) {
                        deque.offerFirst(cur.right);
                    }
                }
            }
            res.add(temp);
            level++;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        _103_BinaryTreeZigzagLevelOrderTraversal btzlot = new _103_BinaryTreeZigzagLevelOrderTraversal();
        List<List<Integer>> res = btzlot.zigzagLevelOrder(root);
        System.out.println(res);
    }
}
