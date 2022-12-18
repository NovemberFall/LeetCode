package Stack.Meta_Phone_BinaryTreePreorderIterator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

class TreeNode{
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

class BinaryTreePreorderIterator implements Iterator<TreeNode> {
    Deque<TreeNode> stack;

    public BinaryTreePreorderIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        if (root != null) {
            stack.push(root);
        }
    }

    @Override
    public TreeNode next() {
        if (hasNext()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            return cur;
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}






