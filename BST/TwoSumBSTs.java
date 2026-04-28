public class TwoSumBSTs {
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

    public static TreeNode insert(TreeNode root , int val){
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (root.val > val) {
            root.left =insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }

    static int sum = 0;
    public static TreeNode bstToGst(TreeNode root) {
        sum = 0;
        reverseInorder(root);
        return root;
    }
    public static void reverseInorder(TreeNode root) {
        if (root == null) return;

        reverseInorder(root.right);

        sum += root.val;     // add current value
        root.val = sum;      // update node

        reverseInorder(root.left);
    }


    public static void inOrder(TreeNode root){
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val +" ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
        int[] values = {4,1,6,5,7};
        TreeNode root = null;
        for(int i=0;i<values.length;i++){
            root = insert(root, values[i]);
        }
        bstToGst(root);
        inOrder(root);
    }
}
