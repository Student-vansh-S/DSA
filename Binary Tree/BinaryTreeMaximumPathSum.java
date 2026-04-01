public class BinaryTreeMaximumPathSum {
    static public class TreeNode {
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
      int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null) return 0;

        // Ignore negative paths
        int left = Math.max(0, maxGain(root.left));
        int right = Math.max(0, maxGain(root.right));

        // Path passing through current node
        int currentPath = left + right + root.val;

        // Update global max
        maxSum = Math.max(maxSum, currentPath);

        // Return max gain to parent
        return root.val + Math.max(left, right);
    }
}
