// import java.util.ArrayList;

public class FlattenBinaryTreeToLinkedList {
    public class TreeNode {
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

    // Approach 1
    // public void flatten(TreeNode root) {
    // ArrayList<TreeNode> ll = new ArrayList<>();
    // preOrder(root, ll); // FIXED

    // int size = ll.size();
    // for (int i = 0; i < size; i++) {
    // ll.get(i).left = null;
    // ll.get(i).right = (i + 1 < size) ? ll.get(i + 1) : null;
    // }
    // }

    // private void preOrder(TreeNode root, ArrayList<TreeNode> ll) {
    // if (root == null)
    // return;

    // ll.add(root); // ROOT FIRST
    // preOrder(root.left, ll);
    // preOrder(root.right, ll);
    // }

    // Approach 2
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }

        curr.right = right;
    }

}
