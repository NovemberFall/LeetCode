package _JavaAPI.Reference;


import org.testng.annotations.Test;

class TreeNode_Reference {
    static class TreeNode {
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

    public static void main(String[] args) {
        TreeNode node = new TreeNode(-1);
        TreeNode copyNode = node;
        copyNode.val = 4;
        System.out.println("Original Node's val => " + node.val);

        System.out.println();

        TreeNode copyNode2 = copyNode;
        copyNode2.val = 55;
        System.out.println(copyNode.val);
        System.out.println("riginal Node's val => " + node.val);
    }


    @Test
    void test_dereference() {
        TreeNode originalNode = new TreeNode(-1);
        TreeNode copyNode = originalNode;
        copyNode.val = 4;
        System.out.println("Original Node's val => " + originalNode.val);
    }
}
