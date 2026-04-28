public class TransformToSumTree {
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

    public static int transfomSumTree(TreeNode root){
        if (root == null) {
            return 0;
        }
        int leftchild = transfomSumTree(root.left);
        int rightchild = transfomSumTree(root.right);
        int data = root.val;
        int newleft = root.left == null ? 0 : root.left.val;
        int newright = root.right == null ? 0 : root.right.val;
        root.val = newleft+leftchild+newright+rightchild;
        return data;
    }

    public static void preorder(TreeNode root){
        if (root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
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
    System.out.println(transfomSumTree(root));
    preorder(root);
    }
}
