public class RecoverBST {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        // 1. Traverse the tree to find the two swapped nodes
        inorder(root);

        // 2. Swap their values back to recover the BST
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        // Left Subtree
        inorder(node.left);

        // Process Current Node: Look for the "drop" in sorted order
        if (prev != null && prev.val > node.val) {
            // If this is the FIRST drop we've seen
            if (first == null) {
                first = prev;
                second = node; // We assign second here to handle adjacent swaps
            } else {
                // If this is the SECOND drop, we only update the 'second' node
                second = node;
            }
        }
        
        // Advance the previous pointer to the current node
        prev = node;

        // Right Subtree
        inorder(node.right);
    }
}
