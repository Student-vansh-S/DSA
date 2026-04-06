public class MirrorBST {
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
    /*
    Leetcode solution
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
    */
    public static TreeNode mirror(TreeNode root){
        if (root == null) {
            return null;
        }
        TreeNode leftSubTree= mirror(root.left);
        TreeNode rightSubTree= mirror(root.right);
        root.left = rightSubTree;
        root.right = leftSubTree;
        return root;
    }
    public static void preOrder(TreeNode root){
        if (root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        /* 
                 8
                / \
               5   10
              / \   \
             3   6   11
        */
        /* 
                 8
                / \
               10  5
              /   / \
             11  6   3
             Mirror BST 
        */
       TreeNode root = new TreeNode(8);
       root.left = new TreeNode(5);
       root.right = new TreeNode(10);
       root.left.left = new TreeNode(3);
       root.left.right = new TreeNode(6);
       root.right.right = new TreeNode(11);
       root = mirror(root);
       preOrder(root);
    }
}
