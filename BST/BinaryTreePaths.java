import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        helper(root, "", result);
        return result;
    }
    private void helper(TreeNode root, String path, List<String> result) {
        if (root == null) return;

        // Build path
        if (path.length() == 0) {
            path += root.val;
        } else {
            path += "->" + root.val;
        }

        // If leaf node → add to result
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        // Recurion call for left & right
        helper(root.left, path, result);
        helper(root.right, path, result);
    }
}
