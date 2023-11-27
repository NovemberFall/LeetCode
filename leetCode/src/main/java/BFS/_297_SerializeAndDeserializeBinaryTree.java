package BFS;

import java.util.ArrayDeque;
import java.util.Queue;

class _297_SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // corner case
        if (root == null) return "";

        //BFS-QUEUE
        Queue<TreeNode> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append("null");
            } else {
                sb.append(cur.val);
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }

        //split string by ","
        String[] arr = data.split(",");

        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        queue.offer(root);

        for (int i = 1; i < arr.length; i++) {
            TreeNode cur = queue.poll();
            if (!arr[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                cur.left = left;
                queue.offer(left);
            }
            if (!arr[++i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                cur.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}
