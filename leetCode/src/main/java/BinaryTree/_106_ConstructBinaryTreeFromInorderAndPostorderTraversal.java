package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
                   1
              /        \
             2          3
           /   \       /   \
         4     5      6     7

 postorder: [4, 5, 2, || 6, 3, 7, || 1]
 inorder:   [4, 2, 5, || 1, || 6, 3, 7]

 */
class _106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inOrderMap = buldMap(inorder);

        return constrcut(inOrderMap,
                inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode constrcut(Map<Integer, Integer> inOrderMap,
                               int[] inorder, int inLeft, int inRight,
                               int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postRight]);
        int inMid = inOrderMap.get(root.val);

        int leftSize = inMid - inLeft;
        int rightSize = inRight - inMid;

        root.left = constrcut(inOrderMap,
                inorder, inLeft, inMid - 1,
                postorder, postLeft, postRight - rightSize - 1);
        root.right = constrcut(inOrderMap,
                inorder, inMid + 1, inRight,
                postorder, postRight - rightSize, postRight - 1);
        return root;
    }


    private Map<Integer, Integer> buldMap(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return map;
    }
}
