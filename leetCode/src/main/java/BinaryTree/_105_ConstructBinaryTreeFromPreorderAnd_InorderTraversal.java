package BinaryTree;

import java.util.HashMap;
import java.util.Map;

class _105_ConstructBinaryTreeFromPreorderAnd_InorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderMap = buildMap(inorder);
        return construct(inOrderMap,
                preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private Map<Integer, Integer> buildMap(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return map;
    }

    private TreeNode construct(Map<Integer, Integer> inOrderMap,
                               int[] preorder, int preLeft, int preRight,
                               int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int leftSubtreeSize = inOrderMap.get(root.val) - inLeft;
        root.left = construct(inOrderMap,
                preorder, preLeft + 1, preLeft + leftSubtreeSize,
                inorder, inLeft, inLeft + leftSubtreeSize - 1);
        root.right = construct(inOrderMap,
                preorder, preLeft + leftSubtreeSize + 1, preRight,
                inorder, inLeft + leftSubtreeSize + 1, inRight);

        return root;
    }
}
