public class KthAncestorOfaBinaryTree {
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

    public static int kAncestor(TreeNode root, int n, int k){
        if (root == null) {
            return -1;
        }
        if (root.val == n) {
            return 0;
        }
        int leftDistance = kAncestor(root.left, n, k);
        int rightDistance = kAncestor(root.right, n, k);

        if (leftDistance == -1 && rightDistance == -1) {
            return -1;
        }
        int max = Math.max(leftDistance, rightDistance);
        if (max+1 == k) {
            System.out.println(root.val);
        }
        return max+1;
    }
    public static void main(String[] args) {
        /*
                 1
                /  \
               2    3
              / \   /\ 
             4   5 8  12
            /     \
           9       6
          /        
        10         
        */
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.left.left.left = new TreeNode(9);
    root.left.left.left.left = new TreeNode(10);

    root.left.right = new TreeNode(5);  
    root.left.right.right = new TreeNode(6); 

    root.right = new TreeNode(3);
    root.right.left = new TreeNode(8);
    root.right.right = new TreeNode(12);
    kAncestor(root, 10, 3);
    }
}
