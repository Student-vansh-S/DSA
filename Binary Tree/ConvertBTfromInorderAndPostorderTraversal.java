import java.util.HashMap;
import java.util.Map;

public class ConvertBTfromInorderAndPostorderTraversal {
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
  int postIndex;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Store inorder value -> index for fast lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        postIndex = postorder.length - 1;

        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        // Pick current root from postorder
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // Find root index in inorder
        int index = inorderMap.get(rootVal);

        //build right subtree first
        root.right = build(postorder, index + 1, inEnd);
        root.left = build(postorder, inStart, index - 1);

        return root;
    }
}
