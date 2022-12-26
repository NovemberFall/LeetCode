package BinarySearchTree._98_ValidateBinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class isBST_BruteForce {
    public boolean isValidBST_ForLoop(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> res = new ArrayList<>();
        convertToList(res, root);
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i - 1) >= res.get(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> res = new ArrayList<>();
        convertToList(res, root);
        return res.stream().sorted().distinct().collect(Collectors.toList()).equals(res);
    }

    private void convertToList(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        convertToList(res, root.left);
        res.add(root.val);
        convertToList(res, root.right);
    }


    public static TreeNode create() {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(20);
        root.left.left = new TreeNode(10);
        root.left.left.left = new TreeNode(5);
        root.left.right = new TreeNode(30);
        root.right = new TreeNode(50);
        root.right.right = new TreeNode(60);
        root.right.left = new TreeNode(47);
        root.left.right.right = new TreeNode(36);
        return root;
    }

    public List<Integer> createList() {
        TreeNode root = create();
        List<Integer> res = new ArrayList<>();
        convertToList(res, root);
        return res;
    }

    public static void main(String[] args) {
        isBST_BruteForce isBST_bruteForce = new isBST_BruteForce();
        List<Integer> res = isBST_bruteForce.createList();
        System.out.println(res);
        System.out.println("======================================");
        TreeNode root = create();
        System.out.println(isBST_bruteForce.isValidBST(root));
    }
}
