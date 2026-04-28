public class MinimumDistanceBetweenNodes {
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
    public static TreeNode LCA2(TreeNode root, int n1,int n2){
        if (root == null || root.val == n1 || root.val == n2) {
            return root;
        }
        TreeNode leftLca = LCA2(root.left,n1,n2);
        TreeNode rightLca = LCA2(root.right,n1,n2);

        if (leftLca == null) {
            return rightLca;
        }
        if (rightLca == null) {
            return leftLca;
        }

        return root;
    }
    public static int lcaDist(TreeNode root, int n){
        if (root == null) {
            return -1;
        }
        if (root.val == n) {
            return 0;
        }
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }
        else if(leftDist == -1){
            return rightDist+1;
        }else{
            return leftDist+1;
        }
    }
    public static int minDist(TreeNode root , int n1 ,int n2){
        TreeNode lca = LCA2(root, n1, n2);
        int dist1 = lcaDist(lca,n1);
        int dist2 = lcaDist(lca ,n2);
        return dist1+dist2;
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
    System.out.println(minDist(root, 4, 12));
    }
}
